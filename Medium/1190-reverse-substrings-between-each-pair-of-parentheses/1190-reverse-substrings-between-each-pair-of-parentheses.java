class Solution {
    public String reverseParentheses(String s) {
          Deque<String> stack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Save current progress, start fresh for inner content
                stack.push(current.toString());
                current = new StringBuilder();
            } else if (c == ')') {
                // Reverse inner content, then attach to previous saved string
                current.reverse();
                current = new StringBuilder(stack.pop() + current);
            } else {
                current.append(c);
            }
        }
        return current.toString();
    }
}