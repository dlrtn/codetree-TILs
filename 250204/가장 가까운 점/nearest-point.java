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
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.add(new Point(x, y));
        }

        for (int i = 0; i < m; i++) {
            Point closedPoint = pq.poll();

            closedPoint.addTwoEach();

            pq.add(closedPoint);
        }

        pq.poll().print();


    }

    public static class Point implements Comparable<Point> {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void addTwoEach() {
            this.x += 2;
            this.y += 2;
        }

        public void print() {
            System.out.println(this.x + " " + this.y);
        }

        @Override
        public int compareTo(Point o) {
            int thisDifference = Math.abs(this.x + this.y);
            int otherDifference = Math.abs(o.x + o.y);

            if (thisDifference == otherDifference) {
                if (this.x == o.x) {
                    return this.y - o.y;
                } else {
                    return this.x - o.x;
                }
            }
            return Math.abs(this.x + this.y) - Math.abs(o.x + o.y);
        }
    }
}
