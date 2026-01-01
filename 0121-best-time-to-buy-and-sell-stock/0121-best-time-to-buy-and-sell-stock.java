class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] finals = new int[n];

        // int[] profit = new int[n];

        // for(int i=0;i<n-1;i++){
        //     int[] profit = new int[n];
        //     for(int j=i+1;j<n;j++){
        //         profit[i]=prices[j]-prices[i];
        //     }
        //     int max=0;
        //     for(int k=0;k<profit.length;k++){
        //         if(profit[k]>max){
        //             max=profit[k];
        //         }
        //     }
        //     finals[i]=max;
            
        // }
        // int ans=0;
        // for(int i=0;i<finals.length;i++){
        //     if(finals[i]>ans){
        //         ans=finals[i];
        //     }
        // }
        
        // return ans;



        // int i=0;
        // while(i<n){
        //     int p=0;
        //     for(int j=i+1;j<n;j++){
                
        //         // System.out.println("profit pehle:"+p+":[i]:"+profit[p]);
        //         profit[p] = prices[j] - prices[i];
        //         p++;
        //         // System.out.println("profit badme:"+p+":[i]:"+profit[p]);
        //     }
        //     int max=0;
        //     for(int k=0;k<profit.length;k++){
        //         if(profit[k]>max){
        //             max=profit[k];
        //         }
        //     }
        //     finals[i]=max;
        //     i++;
        // }
        // int ans=0;
        // for(int w=0;w<finals.length;w++){
        //     if(finals[w]>ans){
        //         ans=finals[w];
        //     }
        // }
        // return ans;

//---------------------------------------------------------------
//time limit exceeded(o[n])-->202 test cases pass hue the
        // int i=0;
        // while(i<n){
        //     int max=0;
        //     for(int j=i+1;j<n;j++){
        //         int profit = prices[j] - prices[i];
        //         if(profit>max){
        //             max=profit;
        //         }
        //     }
        //     finals[i]=max;
        //     i++;
        // }
        // int ans=0;
        // for(int w=0;w<finals.length;w++){
        //     if(finals[w]>ans){
        //         ans=finals[w];
        //     }
        // }
        // return ans;

//---------------------------------------------------------------
    int mini = prices[0];
    int ans=0;
    for(int i=1;i<prices.length;i++){
        if(prices[i]<mini){
            mini = prices[i];
        }
        else{
            int profit = prices[i]-mini;
            if(profit > ans){
                ans=profit;
            }
        }
    }
    return ans;
    }
}