
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Find the maximum frequency for each character in words2
        int[] maxFreq = new int[26];
        for (String b : words2) {
            int[] freq = getFrequency(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        // Check which words in words1 satisfy the conditions
        List<String> result = new ArrayList<>();
        for (String a : words1) {
            int[] freq = getFrequency(a);
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.add(a);
            }
        }

        return result;
    }

    // Helper method to get frequency of each character in a string
    private int[] getFrequency(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
