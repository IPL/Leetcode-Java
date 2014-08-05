

public class Solution {

    public int search(int[] A, int target) {
        int length = A.length;
        return searchHelper(A, target, 0, length - 1);
    }

    private int searchHelper(int[] A, int target, int start, int end) {
        if (start > end)
            return -1;
        else if (start == end)
            return (A[start] == target) ? start : -1;
        int mid = start + (end - start) / 2;
        if (A[start] == target)
            return start;
        else if (A[end] == target)
            return end;
        else if (A[mid] == target)
            return mid;
        if (A[mid] > Math.max(A[start], A[end])) {
            if (target > A[start] && target < A[mid])
                return searchHelper(A, target, start + 1, mid - 1);
            else
                return searchHelper(A, target, mid + 1, end - 1);
        } else if (A[mid] < Math.min(A[start], A[end])) {
            if (target < A[start] && target > A[mid])
                return searchHelper(A, target, mid + 1, end - 1);
            else
                return searchHelper(A, target, start + 1, mid - 1);
        } else { // the array is sorted
            if (target < A[mid])
                return searchCommonHelper(A, target, start + 1, mid - 1);
            else
                return searchCommonHelper(A, target, mid + 1, end - 1);
        }
    }
    
    // binary search in a sorted array
    private int searchCommonHelper(int[] A, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}