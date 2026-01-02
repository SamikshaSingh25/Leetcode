class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] arr = new int[n+1];
        // int[] arr = new int[n+1];
        for(int i=n-1;i>=0;i--){
            if((digits[i])<9){
                digits[i]=digits[i]+1;
                return digits;
            }
            else{
                digits[i]=0;
            }
        }
        int num = arr.length;
        arr[0]=1;
        for(int i=1;i<num;i++){
            arr[i]=0;
        }
        return arr;
    }
        
        
        
}
