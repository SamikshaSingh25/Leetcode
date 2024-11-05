class Solution {
    public int minChanges(String s) {
        char curr  = s.charAt(0);
        int consecutiveCount=0;
        int changes=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == curr){
                consecutiveCount++;
                continue;
            }
            if(consecutiveCount%2==0){
                consecutiveCount=1;
            }
            else{
                consecutiveCount = 0;
                changes++;
            }
            curr = s.charAt(i);
        }
        return changes;
    }
}