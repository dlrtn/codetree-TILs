import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int now = 0;
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            if (s.equals("R")) {
                points.add(new Point(now, true));
                points.add(new Point(now + a, false));
                now += a;
            } else {
                points.add(new Point(now - a, true));
                points.add(new Point(now, false));
                now -= a;
            }
        }

        points.sort(Comparator.comparingInt(p -> p.x));

        int count = 0;
        int answer = 0;
        int prev = 0;
        for (int i = 0; i < n * 2; i++) {
            int x = points.get(i).x;
            boolean isStart = points.get(i).isStart;

            if (count >= k) {
                answer += Math.abs(x - prev);
            }

            if (isStart) {
                count++;
            } else {
                count--;
            }

            prev = x;
        }

        System.out.println(answer);
    }

    public static class Point implements Comparable<Point> {
        int x;
        boolean isStart;

        public Point(int x, boolean isStart) {
            this.x = x;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Point o) {
            return this.x - o.x;
        }
    }
}
