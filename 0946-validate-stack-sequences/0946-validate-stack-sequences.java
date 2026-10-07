class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0; // Pointer for the popped array
        
        for (int val : pushed) {
            stack.push(val); // Always push the current value
            
            // Look at the top of the stack. If it matches the current element
            // we want to pop, then pop it and move our pop pointer forward.
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        
        // If all elements were successfully matched and popped, 
        // the stack will be completely empty.
        return stack.isEmpty();
    }
}
