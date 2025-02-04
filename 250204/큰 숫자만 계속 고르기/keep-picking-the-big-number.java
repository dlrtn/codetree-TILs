import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            int maxNum = pq.poll();
            pq.add(maxNum - 1);
        }

        System.out.println(pq.poll());
    }
}
