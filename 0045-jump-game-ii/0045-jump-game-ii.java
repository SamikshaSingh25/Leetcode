class Solution {
    public int jump(int[] nums) {
        //basically question ke hsiab se can go from i to i+nums[i]
        /** ye kaise hua?.... example in array [2,3,1,1,4]..when we were on 
        i=0(yani 2) we could jump till nums[2] (i+nums[i])...when i =1 (yani 3 )
        we could jump till nums[4] (i+nums[i]=4)..when i=2(yani 1) we could jump 
        till nums[3] (i+nums[i]=3)  */
        int n = nums.length;
        int jumps = 0;
        int curr = 0; //how far we can go with our current jump range (like agar range 4 hai toh curr will be 4 like you can go 4 elemets)
        int last=0; //farthest we can go?(example range(curr) 4 hai but elements he ni bache toh? max we can go will be 1)
        if(n<=1){
            return 0;
        }
        for(int i=0;i<n;i++){
            last=Math.max(last, i+nums[i]);//neccsary coz like 2 se marege phir 3 se toh 3 se lega na
            if(i==curr){ //
                jumps++;
                curr=last;
            }
            if(curr>=n-1){ //curr me value the...but array me na rahi[iykyk ;( ...sad phase chal ra thora]
                break;
            }
        }
        return jumps;
    }
    
}