public class Solution {
    public int singleNumber(int[] A) {
        //ones as a bitmask to represent the i-th bit had appeared once.
        //twos as a bitmask to represent the i-th bit had appeared twice.
        //threes as a bitmask to represent the i-th bit had appeared three times.
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < A.length; i++) {
            twos |= ones & A[i];
            ones ^= A[i];       
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}