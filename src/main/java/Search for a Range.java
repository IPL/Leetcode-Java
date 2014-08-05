public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        int left, right;
        
        int n = A.length;
        left = bsearchCeil(A, target, 0, n);
        // if there is no lower bound, then there is no upper bound either.
        if(left >= n || A[left] != target) {
            left = -1;
            right = -1;
        } else {
            // use lower bound to reduce search space for upper bound
            right = bsearchFloor(A, target, left, n);
        }
        res[0] = left;
        res[1] = right;
        return res;
    }
    
    // return the min index, that a[index] >= target
    private int bsearchCeil(int[] a, int target, int s, int e){
        if(s == e)
            return e;
        int mid = s + (e - s) / 2;
        int val = a[mid];
        if(target > val){
            return bsearchCeil(a, target, mid + 1, e);
        } else {
            return bsearchCeil(a, target, s, mid);
        }
    }
    
    // return the max index that a[index] <= target
    private int bsearchFloor(int[] a, int target, int s, int e){
        if(s == e)
            return s - 1;
        int mid = s + (e - s) / 2;
        int val = a[mid];
        if(target >= val){
            return bsearchFloor(a, target, mid + 1, e);
        } else {
            return bsearchFloor(a, target, s, mid);
        }
    }
}