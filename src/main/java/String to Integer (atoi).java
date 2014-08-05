public class Solution {
    public int atoi(String str) {
        if (str == null)
            return 0;
 
        // trim white spaces
        str = str.trim();
        if (str.length() == 0)
            return 0;
 
        boolean isNeg = (str.charAt(0) == '-');
 
        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;
 
        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
 
        if (isNeg)
            result = -result;
 
        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
 
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
 
        return (int) result;
    }
}