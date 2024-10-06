class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int max[] = new int[n-k+1]; // To store the maximum of each window
        int r = 0;
        // TO store index
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            // remove numbers out of boundary (out of range k) 
            if(!q.isEmpty() && q.peek() == i-k) {
                q.poll(); // Remove the element from the front
            }
            // keep Removing elements from the back that are smaller than the current element
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            // Add current element's index at the back of the deque
            q.offer(i);

            // The first element in deque is the largest for the window 
            if(i >= k-1) {
              max[r++] = nums[q.peek()];
            }

        }

        return max;

    }
}