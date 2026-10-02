class Solution {
    public boolean isAnagram(String s, String t) {
        // Quick check: If lengths don't match, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // 1. Initialize maps using Character instead of String to match s.charAt()
        HashMap<Character, Integer> s_seen = new HashMap<>();
        HashMap<Character, Integer> t_seen = new HashMap<>();
        
        // 2. Add s values to hashmap
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s_seen.containsKey(c)) {
                // Fixed: replaced t_seen with s_seen and added the required '0' default value
                s_seen.put(c, s_seen.getOrDefault(c, 0) + 1);
            }
            else s_seen.put(c, 1);
        }

        // 3. Add t values to hashmap
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            if (t_seen.containsKey(c)) {
                // Fixed: added the required '0' default value
                t_seen.put(c, t_seen.getOrDefault(c, 0) + 1);
            }
            else t_seen.put(c, 1);
        }

        // 4. Check if map sizes match
        if (s_seen.size() != t_seen.size()) {
            return false;
        }

        // 5. Check for parity between maps using Java's map methods
        for (char key : s_seen.keySet()) {
            // If t_seen doesn't even contain the character, or counts don't match, return false
            if (!t_seen.containsKey(key) || !s_seen.get(key).equals(t_seen.get(key))) {
                return false;
            }
        }
        
        // Missing closing bracket for the loop was fixed here
        return true; 
    }
}
