class Solution {
    public String removeOccurrences(String s, String part) {
        int n=s.length();
        int p=part.length();
        StringBuilder str = new StringBuilder(s);
        int i=0;
        while(i<n){ 
            if(s.contains(part)){
                int idx = s.indexOf(part);
                s = s.substring(0,idx)+s.substring(idx+p);
            }
            i++;
        }
        return s;
    }
}