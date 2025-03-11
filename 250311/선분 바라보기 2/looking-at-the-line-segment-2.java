import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            list.add(new Point(x1, y, true, i + 1));
            list.add(new Point(x2, y, false, i + 1));
        }

        list.sort(Comparator.comparingInt(p -> p.x));

        PriorityQueue<Integer> set = new PriorityQueue<>();
        Set<Integer> answer = new HashSet<>();
        for (Point point : list) {
            if (point.isStarted) {
                set.add(point.index);
            } else {
                set.remove(point.index);
            }

            if (!set.isEmpty() && !answer.contains(set.peek())) {
                answer.add(point.index);
            }
        }

        System.out.println(answer.size());
    }

    public static class Point {
        int x;
        int y;
        boolean isStarted;
        int index;

        public Point(int x, int y, boolean isStarted, int index) {
            this.x = x;
            this.y = y;
            this.isStarted = isStarted;
            this.index = index;
        }
    }
}
