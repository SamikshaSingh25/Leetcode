// class Solution {
//     public int[] lexicographicallySmallestArray(int[] nums, int limit) {
//         int n = nums.length;
//         for (int i = 0; i < n; i++) {
//             while (true) {
//                 int small = nums[i];
//                 int idx = -1;

//                 for (int j = i + 1; j < n; j++) {
//                     if (Math.abs(nums[i] - nums[j]) <= limit) {
//                         if (nums[j] < small) {
//                             small = nums[j];
//                             idx = j;
//                         }
//                     }
//                 }
//                 if (idx != -1) {
//                     int temp = nums[i];
//                     nums[i] = nums[idx];
//                     nums[idx] = temp;
//                 } else {
//                     break;
//                 }
//             }
//         }
//         return nums;
//     }
// }

// class Solution {
//     public int[] lexicographicallySmallestArray(int[] nums, int limit) {


//         int len = nums.length;


//         for(int i = 0; i < len - 1; )
//         {
//             boolean flag = true;

//             while(flag)
//             {
//                 int val = nums[i], pos = i;

//                 for(int j = i+1; j < len; j++)
//                 {
//                     if(Math.abs(val - nums[j]) <= limit && val > nums[j])

//                     {
//                         val = nums[j];
//                         pos = j;
//                     }
//                 }


//                 int dup = nums[i];
//                 nums[i] = nums[pos];
//                 nums[pos] = dup;


//                 if(pos == i)
//                 {
//                     flag = false;
//                 }
//             }


//             i++;
//         }


//         return nums;
//     }
// }
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int len = nums.length;

        if(len == 1)
        {
            return nums;
        }

        int temp[] = new int[len];

        for(int i = 0; i < len; i++)
        {
            temp[i] = nums[i];
        }

        Arrays.sort(temp);

        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        int count = 1;

        for(int i = 0; i < len-1; i++)
        {
            map2.put(temp[i], count);
            if(temp[i+1] - temp[i] <= limit)
            {
                List<Integer> tempor = new ArrayList<>();
                if(map1.containsKey(count))
                {
                    tempor = map1.get(count);
                }
                tempor.add(temp[i]);
                map1.put(count, tempor);
            }
            else
            {
                List<Integer> tempor = new ArrayList<>();
                if(map1.containsKey(count))
                {
                    tempor = map1.get(count);
                }
                tempor.add(temp[i]);
                map1.put(count, tempor);
                count++;
            }
        }

        if(temp[len-1] - temp[len-2] <= limit)
        {
            List<Integer> tempor = new ArrayList<>();
            tempor = map1.get(count);
            tempor.add(temp[len-1]);
            map1.put(count, tempor);
        }
        else
        {
            List<Integer> tempor = new ArrayList<>();
            tempor.add(temp[len-1]);
            map1.put(count, tempor);
        }
        map2.put(temp[len-1], count);

        for(int i = 0; i < len; i++)
        {
            int val = nums[i];

            int group = map2.get(val);

            List<Integer> tempo = map1.get(group);

            int data = tempo.get(0);

            temp[i] = data;

            tempo.remove(0);

            if(tempo.size() == 0)
            {
                map1.remove(group);
            }
            else
            {
                map1.put(group, tempo);
            }
        }

        return temp;
    }
}
