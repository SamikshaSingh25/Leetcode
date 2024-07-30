class Solution {
public:
    int minimumDeletions(string s) {
        int n=s.length();
        vector<int> count_a(n, 0);
        vector<int> count_b(n, 0);
        //b ke value count krr re hai..ke vo kitne bar aya, and us count ka array bana re hai
        //(traversing from left to right)
        int countof_b=0;
        for(int i=0;i<n;i++){
            count_b[i]=countof_b;
            if(s[i]=='b'){
                countof_b++;
            }
        }

        //same vohi chiz with a
        //(traversing from right to left)
        int countof_a=0;
        for(int i=n-1;i>=0;i--){
            count_a[i]=countof_a;
            if(s[i]=='a'){
                countof_a++;
            }
        }

        int min_deletion=n;
        for(int i=0;i<n;i++){
            min_deletion = min(min_deletion , abs(count_a[i]+count_b[i]));
        }
        return min_deletion;
    }
};