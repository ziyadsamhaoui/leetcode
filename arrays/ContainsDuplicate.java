"""
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true

Example 2:

Input: nums = [1,2,3,4]
Output: false

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
"""

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // using a hashmap :
        Map<Integer, Integer> counter =  new HashMap<>();

        for( int num : nums ){
            counter.put(num, counter.getOrDefault(num, 0) + 1);
            if( counter.get(num) > 1 ){
                return true;
            }
        }
        return false;

        // using a hashset :
        Set<Integer> seen = new HashSet<>();

        for(int num : nums){
            if(seen.contains(num)) {
                return true;
            } else {
                seen.add(num);
            }

        }
        return false;
    }
}