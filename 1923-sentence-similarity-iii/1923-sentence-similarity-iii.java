class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        /*this question is actually pretty easy you know They must hold either the common prefix or common suffix.
        someedge cases to understand better 
        s1= "hello world python"
        s2= "python"
        ---> True because "python" is suffix of s1
        we can insert the rest on the left

        s1= "hello world python"
        s2= "hello"
        ---> True because "hello" is prefix of s1
        we can insert the rest on the right

        s1= "hello world python"
        s2= "hello python"
        ---> True because "hello" is prefix and "python" is suffix of s1
        we can insert "world" on the middle

        s1= "hello world python"
        s2= "world"
        ---> False because "world" is neither prefix nor suffix of s1
        we can't insert the rest on the left AND right

        basically prefix ya suffix hona chiye.
        */

        //using deque coz age aur piche se pop krna hai ele ko
        //and sath ke sath split bhi kr denge(and store in array)
        Deque<String> d1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        Deque<String> d2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));

        //compare the prefixes or string ke starting
        while(!d1.isEmpty() && !d2.isEmpty() && d1.peek().equals(d2.peek())){
            d1.poll(); //popping
            d2.poll();
        }

        //ending ko compare
        while(!d1.isEmpty() && !d2.isEmpty() && d1.peekLast().equals(d2.peekLast())){
            d1.pollLast(); //popping from THE END
            d2.pollLast();
        }

        /* jab upar ke sare operations perform kr denge toh one of them needs to become empty to satisfy upar wali conditions..but 
        eg in s1= "hello world python" and s2= "world" ... upar ke koi condition full fill ni hoge toh dono empty ni hue
        whereas in s1= "hello world python" and s2= "hello" me 1st wala loop chalega and s2 will become empty
        */
        return d1.isEmpty() || d2.isEmpty();
        ///but this question got trapped in some edge cases...
        //s1="qbaVXO Msgr aEWD v ekcb" s2= "Msgr aEWD ekcb" ...why you might ask.. i wonder WHY THE FUUUKKKK????!!???

        /* My fault... had to do pollLast() instead of poll() in the last while loop so that i would be popping the last element as well 
        my bad hehe */

        //still beats ONLY 15%?????? and submission length exceeds limit?? WOW
    }
}