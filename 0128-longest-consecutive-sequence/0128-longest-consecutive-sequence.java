import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        // We use a HashSet to store all numbers. 
        // This allows us to check if a number exists in O(1) constant time.
        Set<Integer> set = new HashSet<>();
        
        // Add every number from the array into our bag (the HashSet).
        for (int num : nums) {
            set.add(num);
        }

        // This will keep track of the maximum sequence length we find.
        int longestStreak = 0;

        // Loop through the numbers to look for sequences.
        for (int num : set) {
            
            // THE TRICK: We ONLY start counting if 'num' is the very FIRST number of a sequence.
            // How do we know it's the first? Because the number right before it is NOT in the set.
            // For example, if 'num' is 100, we only start if 99 is missing.
            if (!set.contains(num - 1)) {
                
                int currentNum = num;
                int currentStreak = 1;

                // Now that we found a starting number, we keep checking if the set 
                // contains the NEXT number (currentNum + 1).
                while (set.contains(currentNum + 1)) {
                    currentNum += 1; // Move up to the next number
                    currentStreak += 1; // Increase our streak count
                }

                // Compare the streak we just found against our all-time longest streak, 
                // and save the larger one.
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}