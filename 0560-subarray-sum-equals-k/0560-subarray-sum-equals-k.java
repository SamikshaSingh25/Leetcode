class Solution {
    public int subarraySum(int[] nums, int k) {
        //Brute TL:(O(n^2)) most probably
        // int n = nums.length;
        // int sum=0;
        // int c=0;
        // for(int i=0;i<n;i++){
        //     sum=0;
        //     for(int j=i;j<n;j++){
        //        sum+=nums[j];
        //        if(sum==k){
        //         c++;
        //        }
        //     }
        // }
        // return c;


        //Optimised
        int n = nums.length;
        int[] ps = new int[n+1];
        for(int i=0;i<n;i++){
            ps[i+1] = nums[i] + ps[i]; 
        }
        int c=0;
        HashMap<Integer, Integer> hm = new HashMap<>(n+1);

        for(int p:ps){
            c+=hm.getOrDefault(p-k,0);
            hm.merge(p,1,Integer::sum);
        }
        return c;
    }
}