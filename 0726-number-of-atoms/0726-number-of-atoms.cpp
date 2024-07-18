// class Solution {
// public:
//     string countOfAtoms(string formula) {
//         int n=formula.size();
//         map<string,int>mpp; //count string ka
//         stack<long long int>stack;
//         string result="";
//         long long int count=0;
//         long long int multipler=1; //jisse multiply karna hai

//         for(int i=n-1;i>=0;i--){
//             //agar lower case hai
            
//             if(isalpha(formula[i]) && islower(formula[i])){
//                 int len=2; //coz formula lower wala 2 jitna bada he hoga;
//                 i--;
//                 while(i>=0 && islower(formula[i])){
//                     i--;
//                     len++; //just in case more than 2 wala mil gaya
//                 }
//                 string atom = formula.substr(i,len); //isme substring store karenge like Mg was our substring
//                 mpp[atom]+=max(count,1LL)*multipler;  //agar formula me aa ra hai toh 1 bar toh present hoga he
//                 count=0; //next element ke liye
//             }
//             //uppercase
//             else if(isalpha(formula[i]) && isupper(formula[i])){
//                 string atom(1,formula[i]); //isme substring store karenge like Mg was our substring
//                 mpp[atom]+=max(count,1LL)*multipler;  //agar formula me aa ra hai toh 1 bar toh present hoga he
//                 count=0; //next element ke liye
//             }
//             //digit
//             else if(isdigit(formula[i])){
//                 count=formula[i]-'0'; //count conversion from string to count
//                 long long int power=10; //taki multiply karke sahi num mile
//                 //agar previous wala bhi number hai
//                 while(i-1>=0 && isdigit(formula[i-1])){
//                     count+=power*(formula[i-1]-'0');
//                     power*=10;
//                 }
//             }
//             else if(formula[i]==')'){
//                 stack.push(multipler);
//                 multipler*=max(count,1LL);
//                 count=0;
//             }
//             else{
//                 multipler=stack.top();
//                 stack.pop();
//             }

//         }
//         for(const auto& [atom, cnt]:mpp){
//             result+=atom;
//             if(cnt>1){
//                 result+=to_string(cnt);
//             }
//         }
//         return result;
//     }
// };
class Solution {
public:
    string countOfAtoms(string formula) {
        map<string, int> aCount;
        stack<int> mStack;
        string result;
        int count = 0, multiplier = 1;
        
        for (int i = size(formula) - 1; i >= 0; i--) 
        {
            if (isalpha(formula[i]) && islower(formula[i])) 
            {
                int len = 2;
                i--;
                
                while (i >= 0 && islower(formula[i])) 
                {
                    i--;
                    len++;
                }
                
                string atom = formula.substr(i, len);
                aCount[atom] += max(count, 1) * multiplier;
                count = 0;
            } 
            else if (isalpha(formula[i]) && isupper(formula[i])) 
            {
                string atom(1, formula[i]);
                aCount[atom] += max(count, 1) * multiplier;
                count = 0;
            } 
            else if (isdigit(formula[i])) 
            {
                count = formula[i] - '0';
                int power = 10;
                
                while (i - 1 >= 0 && isdigit(formula[i - 1])) {
                    count += power * (formula[--i] - '0');
                    power *= 10;
                }
            } 
            else if (formula[i] == ')') 
            {
                mStack.push(multiplier);
                multiplier *= max(count, 1);
                count = 0;
            } 
            else {
                multiplier = mStack.top();
                mStack.pop();
            }
        }
        
        for (auto [atom, cnt]: aCount) {
            result += atom;
            
            if (cnt > 1) {
                result += to_string(cnt);
            }
        }
        
        return result;
    }
};