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

        PriorityQueue<Number> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll().num);
                }
            } else {
                pq.add(new Number(num));
            }
        }
    }

    public static class Number implements Comparable<Number> {
        int num;

        public Number(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Number o) {
            if (Math.abs(this.num) == Math.abs(o.num)) {
                return this.num - o.num;
            }
            return Math.abs(this.num) - Math.abs(o.num);
        }
    }
}
