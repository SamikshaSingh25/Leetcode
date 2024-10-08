class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        int un = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            //opening brack
            if(ch=='['){
                st.push(ch);
            }
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
                else{
                    un++;
                }
            }

        }
        return (un+1)/2;
    }
}