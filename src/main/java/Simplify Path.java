public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String s : paths) {
            if (s.equals(".")) {
            } else if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (s.length() > 0) {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) 
            sb.append("/" + s);
        if (sb.length() == 0) 
            sb.append("/");
        return sb.toString();
    }
}