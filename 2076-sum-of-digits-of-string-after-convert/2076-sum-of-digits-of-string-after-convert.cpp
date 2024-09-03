class Solution {
public:
    int getLucky(string s, int k) {
        string numString="";
        for(char ch: s){
            numString+=to_string(ch-'a'+1);
        }
        while(k-- > 0){
            int digitSum=0;
            for(char digit : numString){
                digitSum += (digit-'0');  
            }
            numString = to_string(digitSum);
        }
        return stoi(numString);
    }
};