//TLE O(n log k)  k is the value of kth ugly number

// class Solution {
// public:
//     int nthUglyNumber(int n) {
//         if(n<=0) return 0;
//         int count=0;
//         int num2=1;
//         vector<int> res;
//         while(count<n){
//             int num=num2;
//             while(num%2==0){
//                 num/=2;
//             }
//             while(num%3==0){
//                 num/=3;
//             }
//             while(num%5==0){
//                 num/=5;
//             }
//             if(num==1){
//                 count++;
//                 res.push_back(num2);
//             }
//             num2++;
//         }
//         return res[n-1];
//     }
// };



class Solution {
public:
    int nthUglyNumber(int n) {
      if(n<=0) return 0;
      vector<int> res(n);
      int i2=0,i3=0,i5=0;
      int nextmultipleof2 = 2;
      int nextmultipleof3 = 3;
      int nextmultipleof5 = 5;
      res[0]=1;
      for(int i=1;i<n;i++){
        int next = min(nextmultipleof2, min(nextmultipleof3,nextmultipleof5));
        res[i] = next;
        if(next == nextmultipleof2){
            i2++;
            nextmultipleof2 = res[i2]*2;
        }
        if(next == nextmultipleof3){
            i3++;
            nextmultipleof3 = res[i3]*3;
        }
        if(next == nextmultipleof5){
            i5++;
            nextmultipleof5 = res[i5]*5;
        }
      }
      return res[n-1];
    }
};