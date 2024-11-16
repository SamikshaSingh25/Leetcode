class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length;
        int r=n-1;
        int l=0;
        while(l+1<n && arr[l]<=arr[l+1]){
            l++;
        }
        //reached the last point ..kuch ni remove karna
        if(l==n-1){
            return 0;
        }

        while(r>0 && arr[r]>=arr[r-1]){
            r--;
        }
        int len = Math.min(n-l-1, r);
        int i=0, j=r;
        while(i<=l && j<n){
            if(arr[i]<=arr[j]){
                len = Math.min(len, j-i-1);
                i++;
            }
            else{
                j++;
            }
        }
        return len;
    }
}