class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalsum = 0;
        for(int num:nums){
           totalsum = (totalsum + num) % p; //summition of original array
        }
        int t=totalsum%p;
        if(t==0) return 0; //original array ka sum is divisible by the target

        // int minlen = n; //size of array jitna initialise
        
        // //removing every possible subarray
        // for(int i=0;i<n;i++){
        //     long subsum = 0;
        //     for(int j=i;j<n;j++){
        //         subsum+=nums[j]; //subarray ka sum
        //         long r = (totalsum - subsum)%p;

        //         if(r==0){
        //            minlen = Math.min(minlen , j-i+1); 
        //         }

        //     }

        // }
        // return minlen== n ? -1 : minlen; //agar end tak koi sunarray nahi mila toh minlen ke value n he reh jayege..and so return -1 . else return minlen
        HashMap<Integer , Integer> hm = new HashMap<>();
        hm.put(0,-1); //jab pura prefix is the answer
        int curr = 0;
        int minlen = n;
        for(int i=0;i<n;i++){
            curr = (curr+nums[i])%p;
            //calculating what we need to remove
            int rev = (curr - t + p)%p;

            if(hm.containsKey(rev)){
                minlen = Math.min(minlen, i-hm.get(rev));
            }
            hm.put(curr,i);
        }
        return minlen == n ? -1 : minlen; 
    }
}