class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        // if(n<2){
        //     return -1;
        // }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long num : nums){
            pq.offer(num);
        }
        int count=0;
        while(pq.size()>1 ){
            if(pq.peek()>=k){
                break;
            }
            long x=pq.poll();
            long y=pq.poll();
            long val = x*2+y;
            pq.offer(val);
            
            count++;
            
        }
        return count;
    }
}