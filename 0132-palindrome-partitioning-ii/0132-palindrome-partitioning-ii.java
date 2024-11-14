//recursive sol: TC(n^2 nlogn)
//will give tle
// function: helper(String , i, j);


/*  class Solution {
    public int minCut(String s) {
        int n=s.length();
        return helper(s,0,n-1);
    }

    static boolean isPalindrome(String s, int i, int j){
        if(i>=j){
            return true;
        }
        return (s.charAt(i)==s.charAt(j)) && isPalindrome(s,i+1,j-1);
    }

    static int helper(String s, int i, int j){
        if(i>j){
            return 0;
        }
        if(isPalindrome(s,i,j)){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int left = helper(s,i,k);
            int right = helper(s,k+1,j);
            int temp=left + right+1;
            ans=Math.min(ans,temp);
        }
        return ans;
    }
    
} */


// optimizing a little
/* class Solution {
    public int minCut(String s) {
        int n=s.length();
        return helper(s,0,n-1);
    }

    static boolean isPalindrome(String s, int i, int j){
        if(i>=j){
            return true;
        }
        return (s.charAt(i)==s.charAt(j)) && isPalindrome(s,i+1,j-1);
    }

    static int helper(String s, int i, int j){
        if(i>j){
            return 0;
        }
        if(isPalindrome(s,i,j)){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            if(isPalindrome(s,i,k)){
                int temp= 1 + helper(s,k+1,j);
                ans=Math.min(ans,temp);
            }
        }
        return ans;
    }
} */


//memoization
class Solution {
    static int[] dp;
    public int minCut(String s) {
        int n=s.length();
        dp = new  int[n];
        Arrays.fill(dp,-1);
        return helper(s,0,n-1);
    }

    static boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static int helper(String s, int i, int j){
        if(i>j){
            return 0;
        }
        if(isPalindrome(s,i,j)){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        if(dp[i]!=-1){
            return dp[i];
        }
        for(int k=i; k<j; k++){
            if(isPalindrome(s,i,k)){
                int temp= 1 + helper(s,k+1,j);
                ans=Math.min(ans,temp);
            }
        }
        return dp[i]=ans;
    }
} 