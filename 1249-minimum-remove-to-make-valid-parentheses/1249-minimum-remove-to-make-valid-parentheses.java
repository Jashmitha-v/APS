
class Solution {
    public String minRemoveToMakeValid(String s) {
        // Stack to store indices of opening brackets '('
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i] == ')') {
                if (!stack.isEmpty()) {
                    // Found a matching pair, pop the opening bracket index
                    stack.pop();
                } else {
                    // Unmatched closing bracket, mark it for removal
                    arr[i] = '*';
                }
            }
        }
        
        // Any remaining indices in the stack are unmatched opening brackets
        while (!stack.isEmpty()) {
            arr[stack.pop()] = '*';
        }
        
        // Build the final string ignoring the marked elements
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
