public class Solution {
    public int sqrt(int input) {
        if (input < 0) {
            return -1;
        }
        if (input == 0 || input == 1) {
            return input;
        }
        int start = 1;
        int end = input;
        double val1, val2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            val1 = input / mid;
            val2 = input / (mid+1);
            if (mid <= val1 && (mid + 1) > val2)
                return mid;
            if (mid > val1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
}