class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int s=flowerbed.length;
        int count=0;
        //base
        if(s==1){
            if(flowerbed[0]==0) return n<=1;
            else return n==0;
        }
        
        for(int i=0;i<s;i++){
            if(flowerbed[i]==0){
                if(i==0 && flowerbed[i+1]==0){
                    count++;
                    flowerbed[i]=1;
                }
                else if(i==s-1 && flowerbed[i-1]==0){
                    count++;
                    flowerbed[i]=1;
                }
                else if(i>0 && i<s-1 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                    count++;
                    flowerbed[i]=1;
                }
            }
            
        }
        
        
        if(count>=n){
            return true;
        }
        return false;
    }
}