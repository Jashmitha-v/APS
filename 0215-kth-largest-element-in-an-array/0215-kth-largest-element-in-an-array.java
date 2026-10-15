class Solution {
    int findKthLargest(int[] num, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int x : num) {
            pq.offer(x);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}
