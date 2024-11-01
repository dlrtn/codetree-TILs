import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
    static LinkedList<Point> list = new LinkedList<>();
    static int answer = 0;
    static int n;
    static LinkedList<Integer> boomNumbers = new LinkedList<>();

    static int[][] boomNumberDx = {{-2, -1, 0, 1, 2}, {1, -1, 0, 0, 0}, {1, -1, -1, 1, 0}};
    static int[][] boomNumberDy = {{0, 0, 0, 0, 0}, {0, 0, 0, -1, 1}, {1, -1, 1, -1, 0}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    list.add(new Point(i, j));
                }
            }
        }

        backtracking(0);

        System.out.println(answer);
    }

    public static void backtracking(int depth) {
        if (depth == list.size()) {
            calculateBoomCount();
            return;
        }

        for (int i = 0; i < 3; i++) {
            boomNumbers.add(i);
            backtracking(depth + 1);
            boomNumbers.removeLast();
        }
    }

    public static void calculateBoomCount() {
        boolean[][] temp = new boolean[n][n];

        for (int i = 0; i < boomNumbers.size(); i++) {
            installBoom(temp, list.get(i), boomNumbers.get(i));
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j]) {
                    count++;
                }
            }
        }
        
        answer = Math.max(answer, count);
    }

    public static void installBoom(boolean[][] temp, Point point, int boomNumber) {
        int x = point.x;
        int y = point.y;

        for (int i = 0; i < 5; i++) {
            int nx = x + boomNumberDx[boomNumber][i];
            int ny = y + boomNumberDy[boomNumber][i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            temp[nx][ny] = true;
        }
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