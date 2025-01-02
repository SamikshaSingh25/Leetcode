class Solution {
    //brute force:
    // public static boolean isVowel(String s){
    //     if(s==null || s.length() == 0){
    //         return false; //handles null or empty string
    //     }
    //     char firstChar = s.charAt(0); 
    //     char lastChar = s.charAt(s.length()-1);

    //     boolean isFirstVowel = (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u' );
    //     boolean isLastVowel = (lastChar == 'a' || lastChar == 'e' || lastChar == 'i' || lastChar == 'o' || lastChar == 'u');
    //     return isFirstVowel && isLastVowel;
    // }
    // public int[] vowelStrings(String[] words, int[][] queries) {
    //     int[] ans = new int[queries.length];
    //     for(int i=0;i<queries.length;i++){
    //         int left = queries[i][0];
    //         int right = queries[i][1];
    //         int count=0;
    //         for(int j=left;j<=right;j++){
    //             if(isVowel(words[j])){
    //                 count++;
    //                 // System.out.println(words[j]+" "+j+" ");
    //             }
    //         }
    //         ans[i]=count;
    //     }
    //     return ans;
    // }


    //optimized (prefix sum method)
    public static boolean isVowel(String s){
        if(s==null || s.length()==0){
            return false;
        }
        char firstChar = s.charAt(0);
        char lastChar = s.charAt(s.length()-1);
        return isVowelChar(firstChar) && isVowelChar(lastChar);
    }
    public static boolean isVowelChar(char c){
        return c == 'a' || c == 'e' || c=='i' || c=='o' || c=='u';
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int ans[] = new int[queries.length];
        int vowelArr[] = new int[words.length + 1];
        for(int i =0;i<words.length ; i++ ){
            if(isVowel(words[i])){
                vowelArr[i+1] = vowelArr[i]+1;
            }
            else{
                vowelArr[i+1] = vowelArr[i];
            }
        }
        for(int i=0;i<queries.length;i++){
            ans[i] = vowelArr[queries[i][1]+1] - vowelArr[queries[i][0]];
        }
        return ans;
    }
}