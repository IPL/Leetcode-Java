public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = n > 0 ? matrix[0].length : 0;
        return bsearch(matrix, target, 0, n * m -1);
    }
    
    private boolean bsearch(int[][] matrix, int target, int s, int e){
        int n = matrix.length;
        int m = n > 0 ? matrix[0].length : 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int val = matrix[mid / m][mid % m];
            if(target == val)
                return true;
            else if(target > val)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return false;
    }
}