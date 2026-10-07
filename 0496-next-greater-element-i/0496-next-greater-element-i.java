class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Find next greater element for every element in nums2
        for (int i = 0; i < nums2.length; i++) {

            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                int x = stack.pop();
                map.put(x, nums2[i]);
            }

            stack.push(nums2[i]);
        }

        // Elements remaining in stack have no next greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Find answers for nums1
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}