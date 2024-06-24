import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i < n + 1; i++) {
            deque.addLast(i);
        }

        while (deque.size() != 1) {
            deque.removeFirst();
            deque.addLast(deque.pollFirst());
        }
        System.out.println(deque.getFirst());
    }
}