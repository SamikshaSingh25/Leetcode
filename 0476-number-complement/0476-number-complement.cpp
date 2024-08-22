// class Solution {
// public:
//     int findComplement(int num) {
//         int bin=0;
//         int power1=1;
//         int num1=num;
//         while(num1>0){
//             int dig = num1 % 2;  
//             num1=num1/2;
//             bin=bin + (dig*power1);
//             power1=power1*10;
//         }

//         int bin1=bin;
//         int numdigit=0;
//         while(bin1){
//             numdigit++;
//             bin1/=10;
//         }
        
//         int digi=0;
//         int final=0;
//         int powder=1;
//         while(numdigit>0){
//             digi=bin%10;
//             digi = (digi == 1) ? 0 : 1;
//             final+= digi*powder;
//             powder*=10;
//             bin/=10;
//             numdigit--;
//         }

//         int result=0;
//         int power=1;
//         while(final>0){
//             int dig = final % 10;  
//             final=final/10;
//             result=result + dig*power;
//             power=power*2;
//         }
//         return result;
//     }
// };

// class Solution {
// public:
//     int findComplement(int num) {
//         int result=0;
//         int power=1;

//         while(num>0){
//             int digit=num%2; 
//             digit = (digit == 1) ? 0 : 1;
//             result = result + (digit*power);
//             num/=2;
//             power*=2;
//         }
//         return result;
//     }
// };

class Solution {
public:
    int findComplement(int num) {
        if (num == 0) return 1; 

        unsigned int bitmask = ~0; 
        
        
        while (num & bitmask) {
            bitmask <<= 1;
        }

      
        return num ^ ~bitmask;
    }
};