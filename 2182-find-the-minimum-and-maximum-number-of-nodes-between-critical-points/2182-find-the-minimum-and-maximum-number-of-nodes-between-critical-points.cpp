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
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        ListNode* slow = head;
        ListNode* med = slow->next;
        ListNode* fast = med->next;
        vector<int> arr(2);
        arr[0]=-1;
        arr[1]=-1;
        int minc=0,maxc=0,min=INT_MAX,max=0;
        bool a = false;
        while(fast!=nullptr){
            if((med->val>slow->val && med->val>fast->val) || (med->val<slow->val && med->val<fast->val)){
                a=true;
                if(maxc>max){
                    max=maxc;
                }
                if(minc!=0 && minc<min){
                    min=minc;
                }
                minc=0;
            }
            if(a==true){
                maxc++;
                minc++;
            }
            slow=med;
            med = fast;
            fast = fast->next;
        }
        if(max==0){
            return arr;
        }
        arr[0]=min;
        arr[1]=max;
        return arr;
    }
};