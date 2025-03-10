import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Point(x, true));
            list.add(new Point(y, false));
        }

        list.sort((a, b) -> {
            return a.x - b.x;
        });

        int answer = 0;
        int duplicates = 0;
        int now = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 2 * n; i++) {
            Point p = list.get(i);

            if (now != 0 && duplicates > 0) {
                answer += Math.abs(p.x - now);
            }
            if (p.isStarted) {
                duplicates++;
            } else {
                duplicates--;
            }

            if (duplicates == 0) {
                max = Math.max(max, answer);
                answer = 0;
            }

            now = p.x;
        }

        System.out.println(max);
    }

    public static class Point {
        int x;
        boolean isStarted;

        public Point(int x, boolean isStarted) {
            this.x = x;
            this.isStarted = isStarted;
        }
    }
}
