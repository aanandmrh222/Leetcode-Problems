class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        // Traverse nums2 from left to right
        for (int num : nums2) {
            // If the current element is greater 
            // than the element on top of the stack
            while (!st.isEmpty() && num > st.peek()) {
                // Map the popped element's next greater to the current element
                map.put(st.pop(), num);
            }
            // Push the current element onto the stack
            st.push(num);
        }

        // For remaining elements in the stack, there is no next greater element
        while (!st.isEmpty()) {
            map.put(st.pop(), -1);
        }

        // Build the result array for nums1 using the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result; 
    }
}