class Solution {
public:
     int smallestChair(vector<vector<int>>& times, int targetFriend) {
        int at=times[targetFriend][0];
      sort(times.begin(),times.end());
        vector<int> chairs(times.size(),-1);
        for(int i=0;i<times.size();i++)
        {
            int aat=times[i][0];
            int dt=times[i][1];
            for(int j=0;j<times.size();j++)
            {
                if(chairs[j]<=aat)
                {
                    chairs[j]=dt;
                    if(aat==at)
                        return j;
                 break;   
                }
            }
        }
        return 0;
    }
};