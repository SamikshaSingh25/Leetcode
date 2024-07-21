class Solution {
    vector<int>fun(int k,vector<vector<int>>&r){
        vector<int>topo;
        vector<int>adj[k+1];
        vector<int>indegree(k+1,0);
        for(int i=0;i<r.size();i++){
            adj[r[i][0]].push_back(r[i][1]);
            indegree[r[i][1]]++;
        }

        queue<int>q;
        for(int i=1;i<=k;i++){
            if(indegree[i]==0){
                q.push(i);
            }
        }

        

        while(!q.empty()){
            int node=q.front();
            q.pop();

            topo.push_back(node);

            for(auto it : adj[node]){
                indegree[it]--;
                if(indegree[it]==0){
                    q.push(it);
                }
            }
        }
        return topo;
    }
public:
    vector<vector<int>> buildMatrix(int k, vector<vector<int>>& r, vector<vector<int>>& c) {
        int n=r.size();
        vector<int>topo1=fun(k,r);
        //1 
        //3 
        //2

        vector<int>topo2=fun(k,c);
        //3 2 1

        vector<vector<int>>vp(k,vector<int>(k,0));
        map<int,int>mp;
        for(int i=0;i<topo1.size();i++){
            mp[topo1[i]]=i;
        }

        for(int i=0;i<topo2.size();i++){
            ///ith column 
            //s there
            vp[mp[topo2[i]]][i]=topo2[i];
             
        }

        for(auto it : topo1){
            cout<<it<<" ";
        }

        cout<<endl;

        for(auto it : topo2){
            cout<<it<<" ";
        }

        // if(topo1.empty() || topo2.empty()){
        //     vector<vector<int>>mat;
        //     return mat;
        // }

        if(topo1.size()!=k || topo2.size()!=k){
            vector<vector<int>>mat;
            return mat;
        }

        return vp;

        
        




    }
};