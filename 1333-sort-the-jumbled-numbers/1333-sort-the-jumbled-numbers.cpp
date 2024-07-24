class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums)
    {
        map<int,vector<int>> mp;
        vector<int> ans;
        for(auto num : nums)
        {
            long long temp = 0;
            string s = to_string(num);
            int n = s.size();
            for(int i=0; i<n; i++)
            {
                temp = temp*10 + mapping[(s[i] - 48)];
            }
            mp[temp].push_back(num);
        }
        for(auto it : mp)
        {
            int n = it.second.size();
            for(int i=0; i<n; i++)
            {
                ans.push_back(it.second[i]);
            }
        }   
        return ans;
    }
};