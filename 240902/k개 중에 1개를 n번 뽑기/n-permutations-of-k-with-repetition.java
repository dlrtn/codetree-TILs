import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        backtracking(n, k, 0);
    }

    public static void backtracking(int n, int k, int depth) {
        if (depth == n) {
            queue.forEach((item) -> {
                System.out.print(item + " ");
            });
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            queue.add(i);
            backtracking(n, k, depth + 1);
            queue.pollLast();
        }
    }
}