public class Solution {
    public int climbStairs(int n) {
        if ( n == 0)
            return 1;
        else if (n == 1)
            return 1;
        else {
            int result0 = 1;
            int result1 = 1;
            int result2 = 0;
            for (int i = 2; i<= n; i++) {
                result2 = result0+result1;
                result0 = result1;
                result1 = result2;
            }
            return result2;
        }
    }
}