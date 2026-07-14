import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String, List<String>> map = new HashMap<>() ; 

        for(String s :strs){

            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray); 

            if (!map.containsKey(sortedKey)){
                map.put(sortedKey, new ArrayList<>());
            }

            map.get(sortedKey).add(s);
        }
        return new ArrayList<>(map.values());
    }
}