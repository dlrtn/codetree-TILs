import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pq.add(i);

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Point(x, true, i));
            list.add(new Point(y, false, i));
        }

        list.sort((a, b) -> {
            return a.x - b.x;
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 2 * n; i++) {
            Point p = list.get(i);

            int index = p.index;
            boolean isStarted = p.isStarted;

            if (isStarted) {
                map.put(index, pq.poll());
            } else {
                pq.add(map.get(index));
            }
        }

        map.forEach((k, v) -> {
            System.out.print(v + 1 + " ");
        });
    }

    public static class Point {
        int x;
        boolean isStarted;
        int index;

        public Point(int x, boolean isStarted, int index) {
            this.x = x;
            this.isStarted = isStarted;
            this.index = index;
        }
    }
}
