class Solution {
    public boolean isArraySpecial(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i]%2==arr[i+1]%2){
                return false;
            }
        }
        return true;
    }
}