class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        // int count = 0;
        // count = count + numBottles;
        // while(numBottles>=numExchange){
        //     int rem = numBottles % numExchange;
        //     int div = numBottles / numExchange;
        //     numBottles = div + rem;
        //     count = count + div;
        // }
        // return count;
        return numBottles + ((numBottles-1)/(numExchange-1));
    }
};