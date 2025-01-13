class Solution {
    public int minimumLength(String s) {
        int ans = 0;
        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        for(int i:arr){
            ans+=delete(i);
        }
        return ans;
    }
    private int delete(int k){
        if(k==3) return 1;
        else if(k<3) return k;
        else if(k%2==0) return 2;
        else return 1;
    }
}