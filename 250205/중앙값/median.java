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

            PriorityQueue<Integer> ascPq = new PriorityQueue<>();
            PriorityQueue<Integer> descPq = new PriorityQueue<>(Comparator.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());

                ascPq.add(num);
                descPq.add(num);

                if (j % 2 == 0) {
                    printMiddleValue(ascPq, descPq, j);
                }
            }
            System.out.println();
        }
    }

    public static void printMiddleValue(PriorityQueue<Integer> ascPq, PriorityQueue<Integer> descPq, int num) {
        PriorityQueue<Integer> copyAscPq = new PriorityQueue<>();
        PriorityQueue<Integer> copyDescPq = new PriorityQueue<>();

        copyAscPq.addAll(ascPq);
        copyDescPq.addAll(descPq);


        for (int i = 0; i < num / 2; i++) {
            copyDescPq.remove(copyAscPq.poll());
            copyDescPq.poll();
        }

        System.out.print(copyAscPq.poll() + " ");
    }
}