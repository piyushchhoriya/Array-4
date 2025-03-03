## Problem1 Array partition (https://leetcode.com/problems/array-partition/)

//In this problem we will sort the array and then we will add the alternate elements and that will give us the answer

Time Complexity : O(n logn)
Space Complexity : O(1)

class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int sum=0;
        for(int i=1;i<=n;i++){
            if(i%2!=0){
                sum=sum+nums[i-1];
            }
            
        }
        return sum;
    }

}