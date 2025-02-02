class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i]=nums[i];
        }
        Arrays.sort(nums);
        // System.out.println("star:" + nums[0]+" "+nums[1]);
        for(int i=0;i<n;i++){
            boolean ans=true;
            for(int x=0;x<n;x++){
                if(A[x]!=nums[(i+x)%n]){
                    System.out.println("i: "+i+" x: "+x+" dggd:"+((i+x)%n)+" A[i]:"+A[i]+" nums:"+nums[(i+x)%n]);
                    ans=false;
                    break;
                }
            }
            if(ans){
                return true;
            }
        }
        return false;
    }
}