// encoding the combined string with the strs[value] length and '#',
// then decoding back into a list = O(n) time; O(n + m) space

class Solution {

    public String encode(List<String> strs) {
        StringBuilder enc_string = new StringBuilder();

        if (strs == null) {
            return "";
        }

        for (String str : strs) {
            enc_string.append(str.length());
            enc_string.append("#");
            enc_string.append(str);
        }

        return enc_string.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int j = str.indexOf('#', i);

            int length = Integer.parseInt(str.substring(i, j));

            i = j + 1;

            String word = str.substring(i, i + length);
            decodedList.add(word);

            i += length;
        }
    
    return decodedList;

    }
}
