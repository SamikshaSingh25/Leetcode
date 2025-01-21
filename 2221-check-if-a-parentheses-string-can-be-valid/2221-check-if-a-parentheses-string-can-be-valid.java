class Solution {
    public boolean canBeValid(String s, String locked) {
        //greedy
        if(s.length()%2!=0){
            return false;
        }
        int n=s.length();
        int open=0;
        int close=0 ;
        //left se right ->
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='1'){
                if(s.charAt(i)=='('){
                    open++;
                }
                else{
                    open--;
                }
            }
            else{
                open++;
            }
            //System.out.println("open wala:"+open);
            if(open<0) return false;
        }
        //System.out.println("hello");
        for(int i=n-1;i>=0;i--){
            //System.out.println("nehere:"+close);
            if(locked.charAt(i)=='1'){
                if(s.charAt(i)==')'){
                    close++;
                }
                //System.out.println("here:"+close);
                else{
                    close--;
                }
                //System.out.println("now: "+close);
            }
            else{
                close++;
            }
            if(close<0) return false;
        }
        //System.out.println("open:"+open+"  close:"+close);
        //if(s.charAt(n-1)=='(' && locked.charAt(n-1)=='1' || s.charAt(0)==')' && locked.charAt(0)=='1' ) return false;
        if(close>=0 && open>=0){
            return true;
        }
        
        return false;
    }
}