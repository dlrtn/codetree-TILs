import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static Stack<Integer> queue = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, 0, arr);
    }

    public static void solution(int n, int depth, int[] arr) {
        if (depth == n) {
            queue.stream().forEach(i -> System.out.print(i + " "));
            exit(0);
        }

        for (int i = 1; i <= n; i++) {
            if (queue.contains(i)) {
                continue;
            }

            if (queue.isEmpty()) {
                queue.add(i);
                solution(n, depth + 1, arr);
                queue.pop();
            } else if (queue.peek() + i == arr[depth - 1]) {
                queue.add(i);
                solution(n, depth + 1, arr);
                queue.pop();
            }
        }
    }
}