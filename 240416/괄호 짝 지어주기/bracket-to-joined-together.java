import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String brackets = st.nextToken();

        Stack<Character> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < brackets.length(); i++) {
            char nowChar = brackets.charAt(i);
            if (nowChar == '(') {
                stack.push(nowChar);
            } else {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(nowChar);
                }
            }
        }

        char nowChar = stack.pop();
        while (!stack.empty()) {
            char nextChar = stack.pop();
            if (nowChar == nextChar) {
                count++;
            } else {
                count += 2;
            }
        }

        System.out.println(count);
    }
}