class Solution {
public:
    string fractionAddition(string expression) {
       int num=0;
       int denom = 1;
       int i=0;
       while(i<expression.size()){
        int currnum=0;
        int currdenom = 0;

        bool isnegative = false;
        if(expression[i] == '-' || expression[i]=='+'){
            if(expression[i]=='-'){
                isnegative = true;
            }
            i++;
        }

        while(isdigit(expression[i])){
            int val = expression[i]-'0'; //to get digit
            currnum = currnum*10+val;
            i++;
        }

        if(isnegative){
            currnum*=-1;
        }

        i++;

        while(i < expression.size() && isdigit(expression[i])){
            int val = expression[i] - '0';
            currdenom = currdenom*10+val;
            i++;
        }

        num=num*currdenom + currnum*denom;
        denom= denom*currdenom;
       } 

       int gcd = abs(GCD(num, denom));
       num/=gcd;
       denom/=gcd; //reduce to fraction

       return to_string(num)+"/"+to_string(denom);
    }
private:
    int GCD(int a,int b){
        if(a==0) return b;
        return GCD(b%a,a);
    }
};