public class Solution {
    public int trap(int[] A) {
        int length = A.length;
        if (length <= 2)
            return 0;
        // Starting from left, calculate the max value to item
        int lhs[] = new int[length];
        lhs[0] = 0;
        int maxH = A[0];
        for (int i = 1; i< length-1 ; i++) {
            lhs[i] = maxH;
            maxH = Math.max(maxH, A[i]);
        }
        // Starting from right, calculate the max value to item
        int rhs[] = new int[length];
        rhs[length-1] = 0;
        maxH = A[length-1];
        for (int i = length-2; i>0 ; i--) {
            rhs[i] = maxH;
            maxH = Math.max(maxH, A[i]);
        }
        int result = 0;
        for (int i = 0; i<length; i++) {
            result+= Math.max(Math.min(lhs[i], rhs[i]) - A[i], 0);
        }
        return result;
    }
}