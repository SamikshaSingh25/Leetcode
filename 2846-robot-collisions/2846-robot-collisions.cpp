class Solution {
public:
    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
       int n = positions.size();
       vector<int> indices(n), result;
       stack<int> stack;   
       for(int index=0; index<n;index++){
        indices[index]=index;
       }     
       sort(indices.begin(), indices.end(), [&](int a, int b) {
        return positions[a] < positions[b];
        });

       for(int curr:indices){
        if(directions[curr]=='R'){
            stack.push(curr);
        }
        else{
            while(!stack.empty()&& healths[curr]>0){
                int top = stack.top();
                stack.pop();

                if(healths[top]>healths[curr]){
                    healths[top]-=1;
                    healths[curr]=0;
                    stack.push(top);
                }
                else if(healths[top]<healths[curr]){
                    healths[curr]-=1;
                    healths[top]=0;
                }
                else{
                    healths[curr] = 0;
                    healths[top] = 0;
                }
            }
        }
       }
       for(int index=0;index<n;index++){
        if(healths[index]>0){
            result.push_back(healths[index]);
        }
       }                                     
       return result;                                         
    }
};