## Problem2 Maximum Subarray (https://leetcode.com/problems/maximum-subarray/)

//Brute Force aPproach
In this I will use loop inside a loop and generate all valid subarrays and also calculate the maximum sum
Problem with this approach : Time limit excedded
Time Complexity :O(n^2)
Space Complexity : O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum=nums[i];
             max=Math.max(max,sum);
            for(int j=i+1;j<n;j++){
                sum=sum+nums[j];
                max=Math.max(max,sum);
            }   
        }
        return max;
    }
}

//Approach-2 : Using Running sum
In this we are keeping a max variable and a running sum in the max variable we are storing the maximum total while iterating
In the rsum calculation we are adding an element to it and checking if that element is bigger than the rsum if so we are changing 
that value as a rsum and also we are changing max
Time Complexity : O(n)
Space Complexity : O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int rsum=nums[0];
        int max=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            rsum=Math.max(rsum+nums[i],nums[i]);
            max=Math.max(max,rsum);
        }
        return max;
    }
}

//What if the interviewer asks us to give the start and end index. If so we can give it by maintaining 2 variables start and end
Time Complexity : O(n)
Space Complexity : O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int rsum=nums[0];
        int max=nums[0];
        int start=0;
        int end=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(rsum+nums[i] > max){
                end=i;
            }
            if(rsum+nums[i] < nums[i]){
                start=i;
                end=i;
            }
            rsum=Math.max(rsum+nums[i],nums[i]);
            max=Math.max(max,rsum);
        }
        System.out.println("Start "+ start);
        System.out.println("End "+ end);
        return max;
    }
}