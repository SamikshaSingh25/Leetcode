class Solution {
public:
    int findMaxK(vector<int>& nums) {
        unordered_set<int> numSet(nums.begin(), nums.end());
        int largest = -1;

        for (int num : nums) {
            if (num < 0 && numSet.count(-num)) {
                largest = max(largest, abs(num));
            }
        }

        return largest;
    }
};
