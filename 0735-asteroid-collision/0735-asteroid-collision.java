class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean exploded = false;
            
            // A collision occurs ONLY if the top of the stack is moving right (+) 
            // and the current asteroid is moving left (-)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                if (Math.abs(stack.peek()) < Math.abs(ast)) {
                    // The stack top asteroid is smaller; it explodes, pop it and keep checking
                    stack.pop();
                    continue;
                } else if (Math.abs(stack.peek()) == Math.abs(ast)) {
                    // Both are the same size; both explode
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    // The current asteroid is smaller; it explodes
                    exploded = true;
                    break;
                }
            }
            
            // If the current asteroid didn't explode, push it onto the stack
            if (!exploded) {
                stack.push(ast);
            }
        }
        
        // Convert the stack back into an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
