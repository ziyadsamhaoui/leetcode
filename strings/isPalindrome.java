"""
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.


Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
"""

class Solution {
    public boolean isPalindrome(String s) {

        String cleanString = s.replaceAll("[^a-zA-Z]", "").toLowerCase();

        List<Character> stringAsList = new ArrayList<>();
        List<Character> reverseString = new ArrayList<>();

        for (int i = 0; i < cleanString.length(); i++) {
            stringAsList.add(cleanString.charAt(i));
        }

        for (int i = stringAsList.size() - 1; i >= 0; i--) {
            reverseString.add(stringAsList.get(i));
        }

        return reverseString.equals(stringAsList);
    }
}