class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        int n = s.length();
        int count = 1;
        for(int i=1;i<n;i++){
            if(s.charAt(i) == ans.charAt(ans.length()-1)){
                count++;
            
            if(count<3){
                ans.append(s.charAt(i));
            }
            }
            else{
                count=1;
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}