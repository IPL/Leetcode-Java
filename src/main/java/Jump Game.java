public class Solution {
    public boolean canJump(int[] A) {
        int n = A.length;
        int maxStep = 0;
        for(int i = 0; i < n; i++){
            if(maxStep >= n - 1)
                return true;
            if(i > maxStep)
                return false;
            maxStep = Math.max(i + A[i], maxStep);
        }
        return true;
    }
}