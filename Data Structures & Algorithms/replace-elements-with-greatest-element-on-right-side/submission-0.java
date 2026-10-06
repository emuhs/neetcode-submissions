class Solution {
    public int[] replaceElements(int[] arr) {
        int greatest = -1;
        int next = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (greatest < next) {
                greatest = next;
            }
            next = arr[i];
            arr[i] = greatest;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}