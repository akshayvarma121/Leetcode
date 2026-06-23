class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length ;
        String res = "";

        String s1 = strs[0];
        String s2 = strs[n-1];
        int i = 0;
        while(i<s1.length() && i<s2.length())
        {
            if (s1.charAt(i) == s2.charAt(i)){
                res = res+s1.charAt(i);
                i++;

            }else{
                break;
            }
            
        }
        return res;

        
    }
}