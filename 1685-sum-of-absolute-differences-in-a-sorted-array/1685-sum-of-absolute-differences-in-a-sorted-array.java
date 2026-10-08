class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;
        int leftSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < n; i++) {
            int left = nums[i] * i - leftSum;
            int right = (totalSum - leftSum - nums[i]) 
                        - nums[i] * (n - i - 1);

            result[i] = left + right;

            leftSum += nums[i];
        }

        return result;
    }
}