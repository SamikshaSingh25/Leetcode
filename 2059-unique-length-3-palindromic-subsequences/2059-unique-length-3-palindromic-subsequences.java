class Solution {
    public int countPalindromicSubsequence(String s) {
        /** A **HashMap** stores data as key-value pairs, 
        but in this problem, we don't need to store any 
        extra information (values) about the palindromes.
        We only care about keeping track of the unique palindromes, 
        and a **HashSet** does that more simply and efficiently. It’s 
        designed to store unique items without needing additional 
        details, which makes it a better fit here. */
        Set<Character> letters = new HashSet<>();
        for(Character c : s.toCharArray()){  //looking at each character from the string (by transforming the string to character array)
            letters.add(c);
        }
        int ans = 0;
        for(Character letter : letters){ //looking in the hashset
            int i=-1;
            int j=0;
            for(int k=0;k<s.length();k++){
                if(s.charAt(k)==letter){
                    if(i==-1){
                        i=k;
                    }
                    j=k;
                }
            }
            Set<Character> hs2 = new HashSet<>();
            for(int k= i+1;k<j;k++){
                hs2.add(s.charAt(k));
            }
            ans += hs2.size();
        }
        return ans;
    }
}