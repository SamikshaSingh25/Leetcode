class Solution {
    public int maximumSwap(int num) {
        String newnum = Integer.toString(num);
        int n=newnum.length();
        int maxi = num;
        int number=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                char[] digi = newnum.toCharArray();
                char temp = digi[i];
                digi[i]=digi[j];
                digi[j]=temp;

                number = Integer.parseInt(new String(digi));
                maxi=Math.max(number,maxi);
            }
        }
        return maxi;
    }
}
