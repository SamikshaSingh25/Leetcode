class Solution {
    public String lastSubstring(String s) {
        //solution gives tle
        // StringBuilder sb = new StringBuilder();
        // int n = s.length();
        // for(int i=0;i<n;i++){
            
        //     sb = new StringBuilder(sb.toString().compareTo(s.substring(i))>0?sb:s.substring(i)); //greater than 0 meanning true....to string coz comparing string builder with a string isnt allowe
        // }
        // return sb.toString();

        int n=s.length();
        char[] s2 = s.toCharArray();
        int i=0,j=1,k=0;
        while(j+k<n){
            if(s2[i+k]==s2[j+k]){
                k++;
            }
            else if(s2[i+k]>s2[j+k]){
                j=j+k+1;
                k=0;
            }
            else if(s2[i+k]<s2[j+k]){
                i=Math.max(i+k+1,j);
                j=i+1;
                k=0;
            }
        }
        return s.substring(i);
    }
}