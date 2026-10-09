"""
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
"""

class Solution {
    // using the divide and conquer approach :
    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return divide(nums, left, right);
    }

    public int divide(int[] nums, int left, int right){
        if(left == right){
            return nums[left];
        }

        int middle = left + (right - left) / 2;

        int bestLeft = divide(nums, left, middle);
        int bestRight = divide(nums, middle + 1, right);
        int bestCrossSum = maxCrossSum(nums, left, middle, right);

        return Math.max(bestLeft, Math.max(bestRight, bestCrossSum) );
    }

    public int maxCrossSum(int[] nums, int left, int middle, int right){
        int sum = 0;
        int bestCrossLeft = Integer.MIN_VALUE;
        int bestCrossRight = Integer.MIN_VALUE;

        for(int i=middle ; i >= left ; i--){
            sum += nums[i];
            bestCrossLeft = Math.max(sum, bestCrossLeft);
        }

        sum = 0;

        for(int i=middle + 1 ; i <= right ; i++){
            sum += nums[i];
            bestCrossRight = Math.max(sum, bestCrossRight);
        }

        return bestCrossLeft + bestCrossRight;
    }
}