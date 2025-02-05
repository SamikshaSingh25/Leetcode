class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        }
        return count <= 2;
    }
}