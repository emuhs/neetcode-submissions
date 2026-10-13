class Solution {
    public int calPoints(String[] operations) {
        // Keeps track of the valid scores
        int[] record = new int[operations.length];
        int i = 0; // Pointer for the next empty slot in record

        for (String op : operations) {
            if (op.equals("+")) {
                // Add the sum of the last two scores
                record[i] = record[i - 1] + record[i - 2];
                i++;
            } else if (op.equals("D")) {
                // Double the last score
                record[i] = record[i - 1] * 2;
                i++;
            } else if (op.equals("C")) {
                // Invalidate the last score (move pointer back)
                i--; 
                record[i] = 0; 
            } else {
                // If it's none of the above, it must be an integer string
                record[i] = Integer.parseInt(op);
                i++;
            }
        }

        // Sum up all the valid scores up to our pointer
        int score = 0;
        for (int j = 0; j < i; j++) {
            score += record[j];
        }
        
        return score;
    }
}
