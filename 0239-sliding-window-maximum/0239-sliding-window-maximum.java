class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int max[] = new int[n-k+1];
        int r = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            // remove numbers out of boundary (out of range k) 
            if(!q.isEmpty() && q.peek() == i-k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless;
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            q.offer(i);
            if(i >= k-1) {
              max[r++] = nums[q.peek()];
            }

        }

        return max;

    }
}