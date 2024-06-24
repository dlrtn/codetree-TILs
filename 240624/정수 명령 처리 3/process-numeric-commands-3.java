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
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num;

            switch (str) {
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    deque.addFirst(num);
                    break;
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    deque.addLast(num);
                    break;
                case "pop_front":
                    System.out.println(deque.removeFirst());
                    break;
                case "pop_back":
                    System.out.println(deque.removeLast());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    System.out.println(deque.getFirst());
                    break;
                case "back":
                    System.out.println(deque.getLast());
                    break;
            }
        }
    }
}