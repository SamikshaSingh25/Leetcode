class Solution {
    public boolean isValid(String s) {
        //stack banaya
        Stack<Character> st = new Stack<Character> ();
        //each character ko char array me save kar liya
        for(char c:s.toCharArray()){
            //opening brackert ko push kara
            if(c=='('||c=='{'||c=='['){
                st.push(c);
            }
            //closing bracket ka check
            else{
                //agar empty hai stack then iska koi opening ni hai
                if(st.isEmpty()){
                    return false;
                }
                char top = st.peek();
                //match krr re hai
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        //agar st is empty then everything is sorted..otherwise there are unmatched brackets left 
        return st.isEmpty();
    }
}