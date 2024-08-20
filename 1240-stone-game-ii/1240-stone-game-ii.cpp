/*The maximum number of stones that the current player can pick is given 
by the sum of all remaining elements in the array after the current index,
minus the minimum stones value.

To efficiently compute this, we maintain a suffix sum array, which stores 
the sum of elements following the current index.*/

class Solution {
public:
    int stoneGameII(vector<int>& piles) {
        int length=piles.size();
        vector<vector<int>> ans(length+1,vector<int>(length+1,0)); //2d array
        vector<int> suffixSum(length+1,0);

        //iske age ke sare possible suffix ka suffixSum
        for(int i=length-1 ; i>=0;i--){
            suffixSum[i] = suffixSum[i+1]+piles[i];  
        }

        //last column me values dal re hai
        for(int i =0;i<=length;i++){
            ans[i][length] = suffixSum[i];
        }

        //storing future states
        for(int index = length-1;index>=0;index--){
            for(int maxTillNow = length-1;maxTillNow>=1;maxTillNow--){
                for(int x = 1;x<=2*maxTillNow && index+x<=length;x++){
                    ans[index][maxTillNow] = max(ans[index][maxTillNow],suffixSum[index]-ans[index+x][max(maxTillNow,x)]);
                }
            }
        }
        return ans[0][1];
    }
};