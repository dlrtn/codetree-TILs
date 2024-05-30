import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points.add(new Point(x, y));
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 2; i <= 100; i+=2) {
            for (int j = 2; j <= 100; j+=2) {
                int maxCount = 0;

                // 제1사분면
                int quadrant1 = 0;
                for (Point point : points) {
                    if (point.isBetween(0, 0, i, j)) {
                        quadrant1++;
                    }
                }

                // 제2사분면
                int quadrant2 = 0;
                for (Point point : points) {
                    if (point.isBetween(i, j, 100, 100)) {
                        quadrant2++;
                    }
                }

                // 제3사분면
                int quadrant3 = 0;
                for (Point point : points) {
                    if (point.isBetween(0, j, i, 100)) {
                        quadrant3++;
                    }
                }

                // 제4사분면
                int quadrant4 = 0;
                for (Point point : points) {
                    if (point.isBetween(i, 0, 100, j)) {
                        quadrant4++;
                    }
                }

                maxCount = Math.max(quadrant1, Math.max(quadrant2, Math.max(quadrant3, quadrant4)));
                answer = Math.min(answer, maxCount);
            }
        }

        System.out.println(answer);
    }


    public static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public boolean isBetween(int x1, int y1, int x2, int y2) {
            return x > x1 && x < x2 && y > y1 && y < y2;
        }
    }
}