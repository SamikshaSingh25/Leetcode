class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        //brute force-> O(n^3logn) //tle maybe
        int n=A.length;
        int count=0;
        int[] res = new int[n]; //result array will be same size as the original array
        //pehla loop to select each element and stoppin 
        for(int i=0;i<n;i++){
            count=0;
            //dusra loop for comparison
            for(int j=0;j<=i;j++){
                //third loop to store value
                
                for(int k=0;k<=i;k++){
                    if(A[j]==B[k]){
                        count++;
                    }
                }
                res[i]=count;
            }
        }   
        return res;
    }
}