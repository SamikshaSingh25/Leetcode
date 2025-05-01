class Solution {
    public int minDistance(String word1, String word2) {
        //recursive
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        return solve(word1, word2, m, n, dp);
    }
    public int solve(String word1, String word2, int m, int n, int[][] dp){
        if(m==0 || n==0) return m+n;

        if(dp[m][n] != -1) return dp[m][n];

        if(word1.charAt(m-1) == word2.charAt(n-1)){
            return dp[m][n] = solve(word1, word2, m-1, n-1, dp);
        }

        else{
            int rep = 1+solve(word1, word2, m-1, n-1, dp);
            int insert = 1+solve(word1, word2, m, n-1, dp);
            int del = 1+solve(word1, word2, m-1, n, dp);
            return dp[m][n] = Math.min(insert, Math.min(del, rep));
        }   
    }
}