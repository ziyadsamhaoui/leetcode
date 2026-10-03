"""
Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
"""

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() -1;
        int j = b.length() -1;

        while(i >= 0 || j >= 0 || carry == 1){
            char p1 = i >= 0 ? a.charAt(i) : '0';
            char p2 = j >= 0 ? b.charAt(j) : '0';

            if(p1 == '1' && p2 == '1'){
                if(carry == 1){
                    result.append('1');
                } else {
                    result.append('0');
                }
                carry = 1;
            }

            else if(p1 == '1' || p2 == '1'){
                if(carry == 1){
                    result.append('0');
                    carry = 1;
                } else {
                    result.append('1');
                    carry = 0;
                }
            }

            else {
                if(carry == 1){
                    result.append('1');
                    carry = 0;
                } else {
                    result.append('0');
                }
            }

            i--;
            j--;
        }

        return result.reverse().toString();

    }
}