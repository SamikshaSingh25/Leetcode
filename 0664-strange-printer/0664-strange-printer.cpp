class Solution {
public:
    int strangePrinter(string s) {
        if(s.empty()) return 0;
        int length =s.length();
        int i=0;
        string unique;
        while(i<length){
            char curr = s[i];
            unique+=curr;
            while(i < length && s[i]==curr){
                i++;
            }
        }

        int n = unique.length();
        vector<vector<int>> dp(n,vector<int>(n,0));
        //base case
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }

        for(int l=2;l<=n;l++){ //kyuki single charaters handel krr liye hai
            for(int i=0;i<=n-l;i++){
                int j=i+l-1;
                dp[i][j] = dp[i][j-1]+1;
                for(int k=i;k<j;k++){
                    if(unique[k]==unique[j]){
                        dp[i][j]=min(dp[i][j], dp[i][k] + dp[k+1][j-1]);
                    }
                }
            }

        }
        return dp[0][n-1];

        
    }
};