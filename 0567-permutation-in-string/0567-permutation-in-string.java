class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //if s1 is greater than s2 return false imediately
        if(s1.length()>s2.length()) return false;
        //null is a permutation of all
        if(s1.length()==0) return true;
        int[] s1Count = new int[26]; //alphabet 26 letters ke hote hai
        int[] s2Count = new int[26];
        //counting frequency of charaters in s1 and 1st window of s2
        for(int i=0;i<s1.length();i++){
            s1Count[s1.charAt(i)-'a']++; //frequency nikalne ke liye - 'a';
            s2Count[s2.charAt(i)-'a']++;
        }
        //slide window over s2
        for(int i=0;i<s2.length()-s1.length();i++){
            if(matches(s1Count,s2Count)) return true;
            //update karo window ko
            s2Count[s2.charAt(i)-'a']--; //removing 1st char of current window
            s2Count[s2.charAt(i+s1.length())-'a']++; //adding next char
        }

        //last window
        return matches(s1Count,s2Count);
        
    }

    //matches ka logic
    private boolean matches(int[] s1Count, int[] s2Count){
        for(int i=0;i<26;i++){ //sare 26 alphabet possibilites ko check karna
            if(s1Count[i] != s2Count[i]) return false; //over a window check ho ra hai
        }
        return true;
    }
}