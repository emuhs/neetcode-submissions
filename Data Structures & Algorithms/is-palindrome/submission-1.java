class Solution {
    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;
       
        while (i < j) {

            while (!Character.isLetterOrDigit(s.charAt(i)) ) {
                if (i < j) {
                    i++;
                }
                else break;
            }

            while (!Character.isLetterOrDigit(s.charAt(j))) {
                if (j > i) {
                    j--;
                }
                else break;
            }
            
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
