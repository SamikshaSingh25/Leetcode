class Solution {
public:
    int numTeams(vector<int>& rating) {
        int count=0;
        int n=rating.size();
        for(int i=0;i<n;i++){
            int a=rating[i];
            for(int j=i+1;j<n;j++){
                int b=rating[j];
                for(int k=j+1;k<n;k++){
                    int c=rating[k];
                    if((a<b && b<c)||(a>b && b>c)){
                        count++;
                    }
                }
            }
        }
       

        return count;
    }
};