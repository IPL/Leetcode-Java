public class Solution {
    
    static String[] OPERATORS = {"+", "-", "*", "/"};
    
    public int evalRPN(String[] tokens) {
        if (tokens == null)
            return -1;//?
        else {
            Stack<Integer> stack = new Stack<Integer>(); 
            for (int i = 0; i<tokens.length; i++){
                String currToken = tokens[i];
                if (isOperator(currToken)) {
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();
                    int result = applyOperator(operand1, currToken, operand2);
                    stack.push(result);
                } else {
                    int result = Integer.parseInt(currToken);
                    stack.push(result);
                }
            }
            return stack.pop();
        }
    }
    
    private boolean isOperator(String token) {
        for (String operator: OPERATORS) {
            if (operator.equals(token))
                return true;
        }
        return false;
    }
    
    private int applyOperator (int operand1, String operator, int operand2) {
        int result = 0;
        if (operator.equals("+"))
            result = operand1 + operand2;
        else if (operator.equals("-"))
            result = operand1 - operand2;
        else if (operator.equals("*"))
            result = operand1 * operand2;
        else if (operator.equals("/"))
            result = operand1 / operand2;
        else { // ERROR?
        }
        return result;
    }
}