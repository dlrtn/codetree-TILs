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

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            list.add(new Point(x1, true, i + 1));
            list.add(new Point(x2, false, i + 1));
        }

        list.sort(Comparator.comparingInt(p -> p.x));

        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (Point point : list) {
            if (point.isStarted) {
                set.add(point.index);
            } else {
                set.remove(point.index);
            }

            max = Math.max(max, set.size());
        }

        System.out.println(max);
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
