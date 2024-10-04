class Solution {
    public int longestValidParentheses(String s) {

        //my stack approach
        // Stack<Integer> st = new Stack<>();
        // //take indexing me starting me 1 se ho (agar -1 hoga toh vo 0th le lega and calculations ko bother bhi ni karega)
        // st.push(-1);
        // int max = 0;
        // for(int i=0;i<s.length();i++){
        //     char c = s.charAt(i);
        //     if(c=='('){
        //         st.push(i);
        //     }
        //     else{
        //         st.pop();
        //         if(st.isEmpty()){
        //             st.push(i);
        //         }
        //         else{
        //             int l = i-st.peek();
        //             max=Math.max(max,l);
        //         }
        //     }
        // }
        // return max;

        //randomn chinese student approch i saw of deque
        Deque<Integer> st=new ArrayDeque<>();
        st.push(-1);
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                st.push(i); //index is getting pushed
            }
            else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    ans = Math.max(ans, i-st.peek());
                }
            }
        }
        return ans;

    }
}