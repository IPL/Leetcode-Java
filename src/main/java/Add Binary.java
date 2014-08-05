public class Solution {
    public String addBinary(String num1, String num2) {
        if (num1 == null || num1.length() == 0)
            return num2;
        else if (num2 == null || num2.length() == 0)
            return num1;
        else {
            String result = new String();
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            char carry = '0';
            while (i >= 0 || j >= 0) {
                char char1, char2;
                if (i >= 0)
                    char1 = num1.charAt(i);
                else
                    char1 = '0';
                if (j >= 0)
                    char2 = num2.charAt(j);
                else
                    char2 = '0';
                if (char1 == '0' && char2 == '0') {
                    result = carry + result;
                    carry = '0';
                } else if (char1 == '1' && char2 == '0' || char1 == '0'
                        && char2 == '1') {
                    if (carry == '0')
                        result = '1' + result;
                    else {
                        carry = '1';
                        result = '0' + result;
                    }
                } else { // 1 + 1
                    if (carry == '0') {
                        result = '0' + result;
                        carry = '1';
                    } else {
                        result = '1' + result;
                        carry = '1';
                    }
                }
                i--;
                j--;
            }
            //don't forget
            if (carry == '1')
                return carry + result;
            else
                return result;
        }
    }
}