class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum1=0;
        // int sum2=0;
        int ans=0;
        long total=0;
        for(int num: nums ){
            total+=num;
        }
        for(int i=0;i<nums.length-1;i++){ //till-1 coz teher should be atleast 1 element if you split
            sum1+=nums[i];
            long sum2 = total-sum1;
            if(sum1>=sum2){
                ans++;
                // System.out.print("s1 "+sum1+" ");
                // System.out.print("s2 "+sum2+" ");
                // System.out.println();
            }
        }
        return ans;
    }
}