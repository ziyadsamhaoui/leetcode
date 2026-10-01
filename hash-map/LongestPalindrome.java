"""
Given a string s which consists of lowercase or uppercase letters,
return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
"""

class Solution {
    public int longestPalindrome(String s) {
        int paliLength = 0;
        boolean oddExist = false;
        Map<Character, Integer> counter = new HashMap<>();

        // count the frequency of each character in the string
        for (int i=0 ; i < s.length() ; i++) {
            Character c = s.charAt(i);
            counter.put( c, counter.getOrDefault(c, 0) + 1 );
        }
        // check if the count is even
        // then add the character's length to the longest palindrome length
        for (Map.Entry<Character,Integer> element : counter.entrySet()){
            if( element.getValue() % 2 == 0 ) {
                paliLength +=  element.getValue();
            } else {
                // grab just the even value from the counter
                // ex: char = a & count = 3, we only grab 2
                paliLength +=  element.getValue() - 1;
                oddExist = true;
            }
        }
        if(oddExist) {
            // check if a character's count is odd
            // only 1 odd character can be added
            paliLength += 1;
        }

        return paliLength;

    }
}