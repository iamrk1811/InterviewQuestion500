package questions.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class RemoveInvalidParentheses {
//    Q - https://www.geeksforgeeks.org/remove-invalid-parentheses/
    public HashSet<String> solve(String str) {
        int minimumToRemove = getMinimum(str);
        HashSet<String> set = new HashSet<>();
        removeParenthesis(str, minimumToRemove, set);
        return set;
    }
    private void removeParenthesis(String str, int minimumToRemove, HashSet<String> set) {
        if (minimumToRemove == 0) {
            if (isValidString(str))
                set.add(str);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String str1 = str.substring(0, i);
            String str2 = str.substring(i + 1);
            String temp = str1 + str2;
            removeParenthesis(temp, minimumToRemove - 1, set);
        }
    }
    private boolean isValidString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.empty()) {
                    stack.push(ch);
                } else if (stack.peek() == ')') {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }

    private int getMinimum(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.empty()) {
                    stack.push(ch);
                } else if (stack.peek() == ')') {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }


//    code 2
    ArrayList<String> list = new ArrayList<>();
    public ArrayList<String> solve2(String str) {
        removeEnhanced(str, 0, 0, '(', ')');
        if (list.isEmpty()) {
            list.add("");
        }
        return list;
    }
    private void removeEnhanced(String str, int lastI, int lastRemovedPosition, char openParen, char closeParen) {
        int counter = 0;
        for (int i = lastI; i < str.length(); i++) {
            if (openParen == str.charAt(i)) counter++;
            if (closeParen ==  str.charAt(i)) counter--;

            if (counter >= 0) {
                continue;
            }

            for (int j = lastRemovedPosition; j <= i; j++) {
                if (str.charAt(j) == closeParen && (j == lastRemovedPosition || str.charAt(j - 1) != closeParen)) {
                    String left = str.substring(0, j);
                    String right = str.substring(j + 1);
                    removeEnhanced(left + right, i, j, openParen, closeParen);
                }
            }
            return;
        }

        String reverse = new StringBuilder(str).reverse().toString();
        if (openParen == '(') {
            removeEnhanced(reverse, 0, 0, closeParen, openParen );
        } else {
            list.add(reverse);
        }
    }
}
