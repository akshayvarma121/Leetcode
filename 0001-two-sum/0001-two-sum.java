class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create HashMap: stores number -> position
        Map<Integer, Integer> map = new HashMap<>();
        
        // Check every number in the array
        for (int i = 0; i < nums.length; i++) {
            // What number do we need to add to current number to get target?
            int needed = target - nums[i];
            
            // If we already saw that needed number, return both positions!
            if (map.containsKey(needed)) {
                return new int[] { map.get(needed), i };
            }
            
            // Save current number and its position for later
            map.put(nums[i], i);
        }
        
        return new int[] {};
    }
}