class Solution {
public:
    int maxDistance(vector<vector<int>>& arrays) {
        if(arrays.size()<2) return 0;
        int gloabalmin = arrays[0][0];
        int gloabalmax = arrays[0].back();
        int result = 0;
        for(int i=1;i<arrays.size();i++){
            result = max({result, abs(arrays[i].back()-gloabalmin),abs(gloabalmax-arrays[i][0])});
            gloabalmax = max(gloabalmax , arrays[i].back());
            gloabalmin = min(arrays[i][0] , gloabalmin);
        }
        return result;
    }
};