class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                String s1 = words[i];
                String s2 = words[j];
                if(s1.length()>s2.length()) continue;
                if (s2.startsWith(s1) && s2.endsWith(s1)) {
                    c++;
                }
            }
        }
        return c;
    }
}