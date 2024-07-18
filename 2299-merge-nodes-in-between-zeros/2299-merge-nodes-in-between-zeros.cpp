/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
ListNode* Try(const vector<int>& sum, int index, int size){
    if(index==size){
        return NULL;
    }
    ListNode* temp=new ListNode(sum[index]);
    temp->next = Try(sum,index+1,size);
    return temp;
}
    ListNode* mergeNodes(ListNode* head) {
        ListNode* curr=head->next;
        vector<int>sum;
        while(curr){
            int ans=0;
            while(curr&&curr->val!=0){
                ans+=curr->val;
                curr=curr->next;
            }
            if(ans!=0){
                sum.push_back(ans);
            }
            if(curr){
                curr=curr->next;
            }
        }
        return Try(sum,0,sum.size());
    }
};