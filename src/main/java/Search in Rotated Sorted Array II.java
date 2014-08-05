public class Solution {
    public boolean search(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (A[m] == target) 
                return true; //return m in Search in Rotated Array I
            if (A[l] < A[m]) { //left half is sorted
                if (A[l] <= target && target < A[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else if (A[l] > A[m]) { //right half is sorted
                if (A[m] < target && target <= A[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else 
                l++;
        }
        return false;
    }
}