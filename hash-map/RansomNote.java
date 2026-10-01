"""
Given two strings ransomNote and magazine, return true if ransomNote can be constructed
by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
"""

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> counter = new HashMap<>();

        for (int i=0 ; i < magazine.length() ; i++) {
            Character c = magazine.charAt(i);
            counter.put( c, counter.getOrDefault(c, 0) + 1 );
        }

        for (int i=0 ; i < ransomNote.length() ; i++) {
            Character c = ransomNote.charAt(i);
            if ( counter.containsKey(c) && counter.get(c) > 0){
                counter.put( c, counter.getOrDefault(c, 0) - 1 );
            } else {
                return false;
            }
        }

        return true;
    }
}