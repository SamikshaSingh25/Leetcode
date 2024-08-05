class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) {
        int n = arr.size();
        vector<string> distinct;
        for(int i=0;i<n;i++){
            string curr = arr[i];
            bool isdist = true;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(arr[j]==curr){
                    isdist=false;
                    break;
                }
            }
            if(isdist){
                distinct.push_back(curr);
            }
        }
        if(distinct.size()<k){
            return "";
        }
        else{
            return distinct[k-1];
        }
    }
};