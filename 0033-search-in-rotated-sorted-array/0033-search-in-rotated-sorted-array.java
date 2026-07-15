class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int mid = l + (r - l) / 2; // Prevents integer overflow (safer than (l+r)/2)
            
            // Did we find it?
            if (nums[mid] == target) {
                return mid;
            }
            
            // TRICK PART 1: Identify which half is perfectly sorted.
            // If the left number is smaller than or equal to the mid number, 
            // the left half is perfectly sorted.
            if (nums[l] <= nums[mid]) {
                
                // TRICK PART 2: Check if our target lives inside this perfectly sorted left half.
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1; // It's in the left half, so discard the right.
                } else {
                    l = mid + 1; // It's NOT in the left half, so discard the left.
                }
                
            } 
            // Otherwise, the right half MUST be the perfectly sorted side.
            else {
                
                // Check if our target lives inside this perfectly sorted right half.
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1; // It's in the right half, so discard the left.
                } else {
                    r = mid - 1; // It's NOT in the right half, so discard the right.
                }
                
            }
        }
        
        // Target was not found
        return -1; 
    }
}