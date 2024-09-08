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
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        vector<ListNode*> ans(k);

        //Linked list ka size
        int size = 0;
        ListNode* current = head;
        while(current != nullptr){
            size++;
            current = current->next;
        }

        //minimum size for k parts
        int splitSize = size / k;

        //split krne ke baad bache hue nodes
        //distributed to first (size % k) nodes
        int remaining = size%k;

        current = head;
        ListNode* prev = current;
        for(int i=0;i<k;i++){
            ListNode* newPart = current;
            //size of ith part
            int currsize = splitSize;
            if(remaining >0){
                remaining--;
                currsize++;
            }

            //end tak
            int j=0;
            while(j<currsize){
                prev = current;
                if(current!=nullptr){
                    current = current->next;
                }
                j++;
            }

            //cutt of rest of linked list
            if(prev!=nullptr){
                prev->next=nullptr;
            }
            ans[i] = newPart;
        }
        return ans;



    }
};