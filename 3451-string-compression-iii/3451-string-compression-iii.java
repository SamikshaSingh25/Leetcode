class Solution {
    public String compressedString(String word) {
        StringBuilder str = new StringBuilder("");
        int pos = 0;
        while(pos<word.length()){
            int count = 0;
            char curr = word.charAt(pos);
            while(pos<word.length() && count<9 && word.charAt(pos)==curr){
                pos++;
                count++;
            }
            str.append(count).append(curr);
        }
        return str.toString();
    }
}