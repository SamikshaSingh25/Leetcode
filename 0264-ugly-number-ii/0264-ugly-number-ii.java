class Solution {
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
        int[] res = new int[n];
        int i2=0,i3=0,i5=0;
        int multipleof2 = 2;
        int multipleof3 = 3;
        int multipleof5 = 5;
        res[0] = 1;
        for(int i=1;i<n;i++){
            int next = Math.min(multipleof2, Math.min(multipleof3 ,multipleof5));
            res[i] = next ; 
            if(next == multipleof2){
                i2++;
                multipleof2 = res[i2]*2;
            }
            if(next == multipleof3){
                i3++;
                multipleof3 = res[i3]*3;
            }
            if(next == multipleof5){
                i5++;
                multipleof5 = res[i5]*5;
            }
        }
        return res[n-1];
    }
}