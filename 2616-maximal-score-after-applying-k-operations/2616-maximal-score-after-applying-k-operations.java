class Solution {
    public long maxKelements(int[] nums, int k) {
        //brute force not many cases passed
        // int sum=0;
        // int n=nums.length-1;
        // while(k>0){
        //     Arrays.sort(nums);
        //     int i = nums[n];
        //     sum+=i;
        //     int first = (i+2)/3;
        //     nums[n]=first;
        //     k--;
        // }
        // return sum;

        ///priority queue solution
        //making maxheap instead of default min heap in java
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i:nums){
            pq.offer(i);
        }
        //using long instead of long coz overflow happens oter wise and answer goes in negativ
        long sum=0;
        for(int i=0;i<k;i++){
            int n = pq.poll();
            sum+=n;
            pq.offer((n+2)/3);
        }
        return sum;
    
    }
}