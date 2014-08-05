public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length <= 2)
            return A.length;
 
        int prev = 1; // point to previous
        int curr = 2; // point to current
 
        while (curr < A.length) {
            if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
                curr++;
            } else {
                prev++;
                A[prev] = A[curr];
                curr++;
            }
        }
 
        return prev + 1;
    }
}