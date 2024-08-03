class Solution {
public:
    bool canBeEqual(vector<int>& target, vector<int>& arr) {
        sort(target.begin(),target.end());
        int count=0;
        sort(arr.begin(),arr.end());
        for(int i=0;i<target.size();i++){
            if(arr[i]==target[i]){
                count++;
            }
        }
        if(count==target.size()){
            return true;
        }
        else{
            return false;
        }
    }
};