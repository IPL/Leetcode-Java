public class Solution {
    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / powerHelper(x, -n);
        } else {
            return powerHelper(x, n);
        }
    }
    
    public double powerHelper(double x, int n) {
        if (n == 0)
            return 1;
 
        double v = powerHelper(x, n / 2);
 
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
}