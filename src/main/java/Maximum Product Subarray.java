public class Solution {
    public int maxProduct(int[] A) {
        int length = A.length;
        return maxProductHelper(A, 0, length-1);
    }
    
    private int maxProductHelper(int[] A, int start, int end) {
        if (end < start)
            return Integer.MIN_VALUE;
        else if (end == start)
            return A[start];
        else {
            int zero = checkFirstZero(A, start, end);
            if (zero > -1) {
                return Math.max(0, Math.max(maxProductHelper(A, start, zero - 1), 
                                            maxProductHelper(A, zero + 1, end)));
            } else { // no zero
                int negativeCount = checkNegativeCount(A, start, end);
                if (negativeCount % 2 == 0) {
                    return calculateProdut(A, start, end);
                } else {
                    int firstNegative = findFirstNegative(A, start, end);
                    int lastNegative = findLastNegative(A, start, end);
                    if (firstNegative == lastNegative) {
                        return Math.max(maxProductHelper(A, start, firstNegative - 1), 
                                        maxProductHelper(A, firstNegative + 1, end));
                    } else {
                        int temp = Math.max(maxProductHelper(A, start, firstNegative - 1), 
                                            maxProductHelper(A, firstNegative + 1, end));
                        int temp2 = Math.max(maxProductHelper(A, start, lastNegative - 1), 
                                             maxProductHelper(A, lastNegative + 1, end));
                        return Math.max(temp, temp2);
                    }
                }
            }
        }
    }
    
    private int calculateProdut(int[] A, int start, int end) {
        int result = 1;
        for (int i = start; i <= end; i++) {
            result *= A[i];
        }
        return result;
    }
    
    private int checkFirstZero(int[] A, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (A[i] == 0)
                return i;
        }
        return -1;
    }
    
    private int findFirstNegative(int[] A, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (A[i] < 0)
                return i;
        }
        return -1;
    }
    
    private int findLastNegative(int[] A, int start, int end) {
        for (int i = end; i >= start; i--) {
            if (A[i] < 0)
                return i;
        }
        return -1;
    }
    
    private int checkNegativeCount(int[] A, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (A[i] < 0)
                count++;
        }
        return count;
    }
}