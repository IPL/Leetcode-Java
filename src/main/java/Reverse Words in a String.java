public class Solution {
    public String reverseWords(String s) {
        if (s == null)
            return "";
        else {
            s = s.trim();
            if ("".equals(s)) {
                return "";
            } else {
				// StringBuffer is thread-safe
                StringBuffer sb = new StringBuffer();
                int i = s.length() -1;
                int last = i;
                while(i>=0) {
                    while(i>=0 && s.charAt(i)!= ' ') {
                        i--;
                    }
                    String temp = s.substring(i+1, last+1);
                    sb.append(temp);
                    sb.append(" ");
                    while(i>=0 && s.charAt(i) == ' ') {
                        i--;
                    }
                    last = i;
                }
                return sb.toString().trim();
            }
        }
    }
}