import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= n * 2; k++) {
                    int goldCount = dfs(k, arr, j, i);
                    int totalGoldPrice = goldCount * m;
                    int cost = calculateCost(k);

                    if (totalGoldPrice >= cost) {
                        maxCount = Math.max(goldCount, maxCount);
                    }
                }
            }
        }

        System.out.println(maxCount);
    }

    public static int dfs(int maxDepth, int[][] arr, int x, int y) {
        Queue<Point> stack = new LinkedList<>();

        int goldCount = 0;
        stack.add(new Point(x, y, 0));
        boolean[][] visited = new boolean[arr.length][arr.length];
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            Point point = stack.poll();

            if (arr[point.x][point.y] == 1) {
                goldCount++;
            }

            if (point.x + 1 < arr.length && !visited[point.x + 1][point.y]
                    && point.count + 1 <= maxDepth) {
                visited[point.x + 1][point.y] = true;
                stack.add(new Point(point.x + 1, point.y, point.count + 1));
            }

            if (point.y + 1 < arr.length && !visited[point.x][point.y + 1]
                    && point.count + 1 <= maxDepth) {
                visited[point.x][point.y + 1] = true;
                stack.add(new Point(point.x, point.y + 1, point.count + 1));
            }

            if (point.x > 0 && !visited[point.x - 1][point.y] && point.count + 1 <= maxDepth) {
                visited[point.x - 1][point.y] = true;
                stack.add(new Point(point.x - 1, point.y, point.count + 1));
            }

            if (point.y > 0 && !visited[point.x][point.y - 1] && point.count + 1 <= maxDepth) {
                visited[point.x][point.y - 1] = true;
                stack.add(new Point(point.x, point.y - 1, point.count + 1));
            }
        }

        return goldCount;
    }

    public static int calculateCost(int k) {
        return k * k + (k + 1) * (k + 1);
    }

    public static class Point {

        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}