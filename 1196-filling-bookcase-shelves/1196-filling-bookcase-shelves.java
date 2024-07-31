class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n=books.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int maxheight=0;
            int widthleft=shelfWidth;
            for(int j=i-1;j>=0;j--){
                widthleft-=books[j][0];
                maxheight=Math.max(maxheight,books[j][1]);

                if(widthleft>=0){
                    dp[i]=Math.min(dp[i],dp[j]+maxheight);
                }
            }
        }
        return dp[n];
    }
}