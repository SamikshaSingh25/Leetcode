class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> numrank = new HashMap<>();
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        int rank =1;
        for(int i=0;i<sorted.length;i++){
            if(i>0 && sorted[i]>sorted[i-1]){
                rank++;
            }
            numrank.put(sorted[i],rank);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=numrank.get(arr[i]);
        }
        return arr;
    }
}