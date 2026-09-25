from pathlib import Path
from datetime import date
from typing import Dict, List, Tuple

REPO_ROOT: Path = Path(__file__).resolve().parent.parent

README_PATH: Path = REPO_ROOT / "README.md"

# Categories must match the folder names under the repository root.
CATEGORIES: List[str] = [
    "arrays",
    "strings",
    "hash-map",
    "two-pointers",
    "sliding-window",
    "stack",
    "queue",
    "linked-list",
    "binary-search",
    "trees",
    "graphs",
    "heap",
    "backtracking",
    "greedy",
    "dynamic-programming",
    "intervals",
    "bit-manipulation",
    "math",
    "misc",
]

# File extensions counted as solution files.
SOLUTION_EXTENSIONS: Tuple[str, ...] = (
    ".py",
    ".java",
    ".cpp",
    ".c",
    ".cs",
    ".js",
    ".ts",
    ".go",
    ".rs",
    ".kt",
    ".swift",
)

# Files / directories to ignore when counting.
IGNORED_NAMES: Tuple[str, ...] = (
    ".gitkeep",
    "README.md",
    "__pycache__",
)

# Markers delimiting the dynamic section inside README.md.
START_MARKER: str = "<!--START_STATS-->"
END_MARKER: str = "<!--END_STATS-->"

# Helpers

def _is_solution_file(path: Path) -> bool:
    """Return True if *path* is a regular file with a recognised solution extension."""
    return path.is_file() and path.suffix.lower() in SOLUTION_EXTENSIONS


def _is_ignored(name: str) -> bool:
    """Return True if *name* should be skipped during counting."""
    return name in IGNORED_NAMES or name.startswith(".")


def count_solutions(category: str) -> int:
    category_path: Path = REPO_ROOT / category

    if not category_path.is_dir():
        return 0

    count: int = 0
    for entry in category_path.iterdir():
        name: str = entry.name
        if _is_ignored(name):
            continue
        if _is_solution_file(entry):
            count += 1
    return count


def collect_stats() -> Dict[str, int]:
    stats: Dict[str, int] = {}
    for category in CATEGORIES:
        stats[category] = count_solutions(category)
    return stats


def build_stats_section(stats: Dict[str, int]) -> str:
    total: int = sum(stats.values())
    today_str: str = date.today().isoformat()
    num_categories: int = len(CATEGORIES)

    # Build the table rows.
    table_rows: List[str] = []
    for category in CATEGORIES:
        display_name: str = category.replace("-", " ").title()
        table_rows.append(f"| {display_name} | {stats[category]} |")

    table: str = "\n".join(table_rows)

    section: str = (
        f"{START_MARKER}\n"
        "## Statistics\n\n"
        f"**Total Solved:** {total}\n\n"
        f"**Last Updated:** {today_str}\n\n"
        f"**Categories:** {num_categories}\n\n"
        "| Category | Solved |\n"
        "|----------|-------:|\n"
        f"{table}\n"
        f"{END_MARKER}"
    )
    return section


def update_readme(stats: Dict[str, int]) -> bool:
    if not README_PATH.is_file():
        print(f"ERROR: {README_PATH} not found.")
        return False

    original: str = README_PATH.read_text(encoding="utf-8")

    if START_MARKER not in original or END_MARKER not in original:
        print(f"ERROR: Markers {START_MARKER!r} / {END_MARKER!r} not found in README.")
        return False

    new_section: str = build_stats_section(stats)

    # Replace everything between (and including) the markers.
    start_idx: int = original.index(START_MARKER)
    end_idx: int = original.index(END_MARKER) + len(END_MARKER)

    updated: str = original[:start_idx] + new_section + original[end_idx:]

    if updated == original:
        return False

    README_PATH.write_text(updated, encoding="utf-8")
    return True


# Entry point

def main() -> None:
    """Scan all categories and update the README statistics section."""
    stats: Dict[str, int] = collect_stats()
    modified: bool = update_readme(stats)

    if modified:
        print("README.md updated successfully.")
    else:
        print("README.md is already up to date.")

    # Print summary for workflow logs.
    total: int = sum(stats.values())
    print(f"\nTotal solutions: {total}")
    for category, count in stats.items():
        print(f"  {category}: {count}")


if __name__ == "__main__":
    main()
