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

        int answer = 0;
        // xxx
        for (int j = 0; j <= 10; j++) {
            for (int k = 0; k <= 10; k++) {
                for (int i = 0; i <= 10; i++) {
                    boolean[] visited = new boolean[n];
                    for (Point point : points) {
                        int x = point.x;
                        int y = point.y;

                        if (x == i || x == j || x == k) {
                            visited[points.indexOf(point)] = true;
                        }
                    }

                    int count = 0;
                    for (int l = 0; l < visited.length; l++) {
                        if (visited[l]) {
                            count++;
                        }
                    }

                    if (count == n) {
                        answer = 1;
                    }
                }
            }
        }
        // xxy
        for (int j = 0; j <= 10; j++) {
            for (int k = 0; k <= 10; k++) {
                for (int i = 0; i <= 10; i++) {
                    boolean[] visited = new boolean[n];
                    for (Point point : points) {
                        int x = point.x;
                        int y = point.y;

                        if (x == i || x == j || y == k) {
                            visited[points.indexOf(point)] = true;
                        }
                    }

                    int count = 0;
                    for (int l = 0; l < visited.length; l++) {
                        if (visited[l]) {
                            count++;
                        }
                    }

                    if (count == n) {
                        answer = 1;
                    }
                }
            }
        }

        // xyy
        for (int j = 0; j <= 10; j++) {
            for (int k = 0; k <= 10; k++) {
                for (int i = 0; i <= 10; i++) {
                    boolean[] visited = new boolean[n];
                    for (Point point : points) {
                        int x = point.x;
                        int y = point.y;

                        if (x == i || y == j || y == k) {
                            visited[points.indexOf(point)] = true;
                        }
                    }

                    int count = 0;
                    for (int l = 0; l < visited.length; l++) {
                        if (visited[l]) {
                            count++;
                        }
                    }

                    if (count == n) {
                        answer = 1;
                    }
                }
            }
        }
        // yyy
        for (int j = 0; j <= 10; j++) {
            for (int k = 0; k <= 10; k++) {
                for (int i = 0; i <= 10; i++) {
                    boolean[] visited = new boolean[n];
                    for (Point point : points) {
                        int x = point.x;
                        int y = point.y;

                        if (y == i || y == j || y == k) {
                            visited[points.indexOf(point)] = true;
                        }
                    }

                    int count = 0;
                    for (int l = 0; l < visited.length; l++) {
                        if (visited[l]) {
                            count++;
                        }
                    }

                    if (count == n) {
                        answer = 1;
                    }
                }
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
    }
}