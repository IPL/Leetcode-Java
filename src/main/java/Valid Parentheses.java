public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        } else {
            Stack<String> stack = new Stack<String>();
            for (int i = 0; i< s.length(); i++) {
                String character = s.substring(i,i+1);
                if ("(".equals(character) 
                    || "{".equals(character) 
                    || "[".equals(character) ){
                    stack.push(character);
                } else {
                    if (stack.isEmpty())
                        return false;
                    String top = stack.pop();
                    if (!("(".equals(top) && ")".equals(character)
                          || "[".equals(top) && "]".equals(character) 
                          || "{".equals(top) && "}".equals(character) 
                         )
					    )
                        return false;
                }
            }
            return stack.isEmpty();
        }
    }
}