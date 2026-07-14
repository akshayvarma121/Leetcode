class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num:nums){
            set.add(num);
        }
        int ls = 0;
        
        for(int num : set){
            if(!set.contains(num-1)){
                int currentnum = num; 
                int currentStreak = 1;
                
                while(set.contains(currentnum+1)){
                    currentnum++;
                    currentStreak++;
                
                }
                if (currentStreak>ls) ls=currentStreak;               


            }
            
            
        }
        return ls;
    }
}