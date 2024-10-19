class Solution {
private:
    string revInv(string prevStr)
    {
        string str = prevStr ;

        // inverse string
        for(char &ch : str){
            ch = (ch == '0') ? '1' : '0' ;
            
        }

        // reverse string
        reverse(str.begin(), str.end());
        return str ;

    }
    string findStr(int n)
    {
        // base case
        if(n==1) return "0";

        // find previous string
        string prevStr = findStr(n-1);

        return prevStr + "1" + revInv(prevStr);
    }
public:
    char findKthBit(int n, int k) {
        string s = findStr(n);

        // return kth bit
        return s[k-1];
    }
};