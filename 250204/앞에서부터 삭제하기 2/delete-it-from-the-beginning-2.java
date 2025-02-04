import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            pq.add(arr[i]);
        }

        double max = Double.MIN_VALUE;

        for (int i = 0; i < n - 2; i++) {
            sum -= arr[i];
            pq.remove(arr[i]);

            double avg = (double) (sum - pq.peek()) / (pq.size() - 1);

            max = Math.max(avg, max);
        }

        System.out.printf("%.2f", max);
    }
}
