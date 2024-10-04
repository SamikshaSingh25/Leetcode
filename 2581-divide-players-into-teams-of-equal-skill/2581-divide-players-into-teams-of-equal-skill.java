class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n=skill.length;
        long ans=0;
        int k=0;
        int j=n-1;
        int sum=skill[k]+skill[j]; 
        for(int i=0;i<n/2;i++){
            // for(int j=n-1;j>n/2;j--){
            ans+=skill[k]*skill[j];
            if(sum != (skill[k]+skill[j])){
                return -1;
            }
            k++;
            j--;
            // }
        }
        return ans;
    }
}