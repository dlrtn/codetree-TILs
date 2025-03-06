import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            points.add(new Point(a, true, i));
            points.add(new Point(b, false, i));
        }

        points.sort(Comparator.comparingInt(p -> p.x));

        int max = Integer.MIN_VALUE;
        int answer = 0;
        for (int i = 0; i < n * 2; i++) {
            int x = points.get(i).x;
            int index = points.get(i).index;
            boolean isStart = points.get(i).isStart;

            if (isStart) {
                answer++;
            } else {
                answer--;
            }

            max = Math.max(max, answer);
        }

        System.out.println(max);
    }

    public static class Point implements Comparable<Point> {
        int x;
        boolean isStart;
        int index;

        public Point(int x, boolean isStart, int index) {
            this.x = x;
            this.isStart = isStart;
            this.index = index;
        }

        @Override
        public int compareTo(Point o) {
            return this.x - o.x;
        }
    }
}
