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

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                if (j % 2 == 0) {
                    maxHeap.add(Integer.parseInt(st.nextToken()));
                } else {
                    minHeap.add(Integer.parseInt(st.nextToken()));
                }

                if (!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }

                if (j % 2 == 0) {
                    System.out.print(maxHeap.peek() + " ");
                }
            }
            System.out.println();
        }
    }
}