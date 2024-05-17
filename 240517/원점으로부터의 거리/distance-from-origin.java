import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        ArrayList<Point> points = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points.add(new Point(i + 1, x, y));
        }

        points.sort((o1, o2) -> {
            int o1Distance = Math.abs(0 - o1.x) + Math.abs(0 - o1.y);
            int o2Distance = Math.abs(0 - o2.x) + Math.abs(0 - o2.y);
            return o1Distance - o2Distance;

        });

        for (Point h : points) {
            h.print();
        }

    }

    public static class Point {

        private int index;
        private int x;
        private int y;

        public Point(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }

        public void print() {
            System.out.println(index);
        }
    }
}