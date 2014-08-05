public class Solution {
    public int reverse(int x) {
        //flag marks if x is negative
        boolean flag = false;
        if (x < 0) {
            x = 0 - x;
            flag = true;
        }
     
        int res = 0;
     
        while (x > 0) {
            int mod = x % 10;
            x = x / 10;
            res = res * 10 + mod;
        }
     
        if (flag) {
            res = 0 - res;
        }
     
        return res;
    }
}