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