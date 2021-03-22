import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        StringBuffer reversed = new StringBuffer();
        while (!stack.empty()) {
            reversed.append(stack.pop());
        }
        return  reversed.toString();
    }
}
