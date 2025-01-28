class Solution {
        public int minTimeToReach(int[][] A) {
        int n = A.length, m = A[0].length, inf = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], inf);
        }
        PriorityQueue<int[]> h = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        h.offer(new int[]{0, 0, 0}); // arrive time, i, j
        A[0][0] = -1;

        while (!h.isEmpty()) {
            int[] cur = h.poll();
            int t = cur[0], i = cur[1], j = cur[2];
            if (t >= dp[i][j]) continue;
            if (i == n - 1 && j == m - 1) return t;
            dp[i][j] = t;

            int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (0 <= x && x < n && 0 <= y && y < m && dp[x][y] == inf) {
                    h.offer(new int[]{Math.max(A[x][y], t) + 1, x, y});
                }
            }
        }
        return -1;
    }
}