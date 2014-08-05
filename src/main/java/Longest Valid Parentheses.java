public class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0, last = -1;
        Stack<Integer> lefts = new Stack<Integer>();
        for (int i=0; i<s.length(); ++i) {
            if (s.charAt(i)=='(') {
                lefts.push(i);
            } else {
                if (lefts.isEmpty()) {
                    // no matching left
                    last = i;
                } else {
                     // find a matching pair
                     lefts.pop();
                     if (lefts.isEmpty()) {
                         // has a complete valid group
                         maxLen = Math.max(maxLen, i-last);
                     } else {
						 // there is unmatched '('
						 // check the index of the last unmatched '('
                         maxLen = Math.max(maxLen, i-lefts.peek());
                     }
                 }
             }
         }
         return maxLen;
    }
}