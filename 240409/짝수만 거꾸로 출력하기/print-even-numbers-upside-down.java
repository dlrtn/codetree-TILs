import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int j = Integer.parseInt(st.nextToken());
            if (j % 2 == 0) {
                stack.push(j);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}