class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to group anagrams
        Map<String, List<String>> groups = new HashMap<>();

        // Loop through each of the strings in the array = O(m)
        for (String s : strs) {

            // Count number of characters in current String = O(n) TC, O(n) aux SC
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                // increment the count value at the index of current value - a
                count[c - 'a']++;
            }

            // Convert count to a string using StringBuilder = still O(n)
            StringBuilder sb = new StringBuilder();
            // Add each value 'i' to the string, #-separated
            for (int i : count) {
                sb.append('#');
                sb.append(i);
            }
            String key = sb.toString();

            // Add to groups
            // If the key doesn't exist in the map yet, give it an empty list
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            // Match key to group
            groups.get(key).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}

// Total TC: O(m x n)
// Total SC: O(m x n)
// Aux SC = O(n) to construct character counters in m strings

