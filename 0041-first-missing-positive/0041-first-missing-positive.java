class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int ele : nums){
            set.add(ele);
        }
        //{5,4,3,2,1}--->n+1

        for (int i = 1; i<=n+1; i++){
            if(set.contains(i)==false)return i;
        }
        return 0 ;

    }
}