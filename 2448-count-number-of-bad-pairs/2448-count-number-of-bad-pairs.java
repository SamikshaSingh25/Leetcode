// Brute force approach by using 2 for loops to check every possible pair takes much more time 

// optimal solution 
class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long totalPairs = 0;
        long goodPairs = 0;
        long badPairs = totalPairs - goodPairs;

        HashMap <Integer,Integer> map = new HashMap <> ();
        for(int i=0; i<n; i++){
            int diff = i - nums[i];
            if(map.containsKey(diff)){
                goodPairs += map.get(diff);
            }
            map.put(diff,map.getOrDefault(diff,0) + 1);
        }
       
       //Total Pairs 
        totalPairs = n*(n-1)/2;
       badPairs = totalPairs - goodPairs;
       return badPairs;

    }
}

// Time complexity : O(n)
// Space Complexity : O(n)

