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
        while (!list.isEmpty()) {
            Point p = list.remove(0);

            if (now != 0 && duplicates > 0) {
                answer += Math.abs(p.x - now);
            }

            if (p.isStarted) {
                duplicates++;
            } else {
                duplicates--;
            }

            now = p.x;
        }

        System.out.println(answer);
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
