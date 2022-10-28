import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task1 {

    public static boolean isBalanced = true;
    static boolean IsBalanced(String expr) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            } else if (x == ' ') {
                continue;
            }

            char check;
            try {
                switch (x) {
                    case ')':
                        check = stack.pop();
                        if (check == '[' || check == '{') return !isBalanced;
                        continue;
                    case ']':
                        check = stack.pop();
                        if (check == '(' || check == '{') return !isBalanced;
                        continue;
                    case '}':
                        check = stack.pop();
                        if (check == '(' || check == '[') return !isBalanced;
                }
            } catch(NoSuchElementException e) {
                return !isBalanced;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Enter mathematical formula|/expression");
        Scanner in = new Scanner(System.in);
        String expr = in.nextLine();
        if (IsBalanced(expr)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced!");
        }
    }
}
