class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                // Get the top two elements without permanently removing them yet
                int top = stack.pop();
                int newScore = top + stack.peek();
                
                // Push them both back, plus the new sum
                stack.push(top);
                stack.push(newScore);
            } 
            else if (op.equals("D")) {
                // Double the top element and push it
                stack.push(stack.peek() * 2);
            } 
            else if (op.equals("C")) {
                // Remove the last valid score
                stack.pop();
            } 
            else {
                // If it's a number string, convert it to an int and push it
                stack.push(Integer.parseInt(op));
            }
        }

        // Sum up everything left in the stack
        int totalScore = 0;
        for (int score : stack) {
            totalScore += score;
        }

        return totalScore;
    }
}