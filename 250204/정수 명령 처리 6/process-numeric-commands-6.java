import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String instruction = st.nextToken();

            switch (instruction) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    pq.add(num);
                    break;
                case "pop":
                    System.out.println(pq.poll());
                    break;
                case "size":
                    System.out.println(pq.size());
                    break;
                case "empty":
                    System.out.println(pq.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    System.out.println(pq.isEmpty() ? -1 : pq.peek());
                    break;
            }
        }
    }
}
