// encoding the combined string with the strs[value] length and '#',
// then decoding back into a list = O(n) time; O(n + m) space

class Solution {

    public String encode(List<String> strs) {

        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {

        
        List<String> decoded_str = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;

            while (str.charAt(j) != '#'){
                j++;
            }
            int str_length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + str_length;
            decoded_str.add(str.substring(i,j));
            i = j;

        }
        return decoded_str;

    }
}
