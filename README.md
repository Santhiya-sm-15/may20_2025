# may20_2025
The problem that i solved today in leetcode

1.You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].

For each queries[i]:

Select a subset of indices within the range [li, ri] in nums.
Decrement the values at the selected indices by 1.
A Zero Array is an array where all elements are equal to 0.

Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.

Code:
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] arr=new int[n];
        for(int[] x:queries)
        {
            int l=x[0];
            int r=x[1];
            arr[l]-=1;
            if(r+1<n)
                arr[r+1]+=1;
        }
        for(int i=1;i<n;i++)
            arr[i]+=arr[i-1];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]+arr[i]<=0) cnt++;
        }
        return cnt==n;
    }
}
