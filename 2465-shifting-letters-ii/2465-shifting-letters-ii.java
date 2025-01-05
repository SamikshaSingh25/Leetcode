class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffArray = new int[n];
        
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];
            
            diffArray[start] += (dir == 1) ? 1 : -1;
            if (end + 1 < n) {
                diffArray[end + 1] += (dir == 1) ? -1 : 1;
            }
        }
        
        char[] chars = s.toCharArray();
        int numberOfShifts = 0;
        
        for (int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + diffArray[i]) % 26;
            if (numberOfShifts < 0) numberOfShifts += 26;
            chars[i] = (char) ('a' + (chars[i] - 'a' + numberOfShifts) % 26);
        }
        
        return new String(chars);
    }
}