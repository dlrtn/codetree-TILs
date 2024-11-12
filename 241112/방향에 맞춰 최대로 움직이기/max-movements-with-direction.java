import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static int[][] direction;
    static int[] dx = {0, 0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        direction = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                direction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;

        Point start = new Point(y, x);

        backtracking(0, start);

        System.out.println(answer);
    }

    public static void backtracking(int depth, Point point) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(point, depth));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            answer = Math.max(answer, node.depth);

            int[] dir = getDirection(node.point);

            int ny = node.point.y;
            int nx = node.point.x;
            while (true) {
                ny += dir[0];
                nx += dir[1];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    break;
                }

                if (map[ny][nx] > map[node.point.y][node.point.x]) {
                    queue.add(new Node(new Point(ny, nx), node.depth + 1));
                }
            }
        }
    }

    public static int[] getDirection(Point point) {
        int[] dir = new int[2];
        dir[0] = dy[direction[point.y][point.x]];
        dir[1] = dx[direction[point.y][point.x]];
        return dir;
    }

    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static class Node {
        Point point;
        int depth;

        public Node(Point point, int depth) {
            this.point = point;
            this.depth = depth;
        }
    }
}
