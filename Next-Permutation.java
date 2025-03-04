## Problem3  Next permutation(https://leetcode.com/problems/next-permutation/)
Step 1 : It is a 3 step process 1. From the right find the element which in smaller than the right it u do not find it then i will become -1
Step 2 : Find the next greater element to it''s right and swap them
Step 3 : Reverse the elements after the pivot which you found in step 1
//Time Complexity : O(n)
//Space Complexity :O(1)

class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i!=-1){
            int j=n-1;
            while(j>i && nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1,n-1);
    }
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void reverse(int[] nums, int left, int right){
        while(left<=right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}