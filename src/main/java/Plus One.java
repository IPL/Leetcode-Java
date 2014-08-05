public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
        else {
            int end = digits.length -1;
            digits[end] += 1;
            boolean carry = false;
            while(end >= 0) {
                if (digits[end] >= 10) {
                    digits[end] = digits[end] - 10;
                    if (end >= 1)
                        digits[end-1] += 1;
                    else 
                        carry = true;
                } else
					break;
                end --;
            }
            //don't forget
            if (carry) {
                int[] result = new int[digits.length+1];
                result[0] = 1;
                return result;
            } 
            return digits;
        }
    }
}