class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int max = 0;
        int min = Integer.MAX_VALUE;

        if(n==0){
            return 0;
        }

        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int var = max-min;


        int[][] temp = new int[n][var+1];
        int ans=1;

        for (int i = 0; i < n; i++) {
            for (int d = 0; d <= var; d++) {
                temp[i][d]=1;
            }
        }

        for(int i=1; i<n; i++){
            
            for (int j = var - 1; j >= 0; j--) {
                temp[i - 1][j] = Math.max(temp[i - 1][j], temp[i - 1][j + 1]);
            }
            for (int j = 0; j < i; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                temp[i][diff] = Math.max(temp[i][diff], 1 + temp[j][diff]);
                ans = Math.max(ans, temp[i][diff]);
            }
            
        }
 
        return ans;
    }
}