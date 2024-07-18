#include <string>
using namespace std;

class Solution {
public:
    string reversePrefix(string word, char ch) {
        int index = word.find(ch); // Find the index of the first occurrence of ch
        if (index != string::npos) { // If ch exists in word
            reverse(word.begin(), word.begin() + index + 1); // Reverse the segment from 0 to index (inclusive)
        }
        return word; // Return the resulting string
    }
};
