import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        Point start = new Point(0, 0);
        Point end = new Point(0, 0);
        String[][] arr = new String[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < 10; j++) {
                String temp = str.substring(j, j + 1);
                arr[i][j] = temp;

                if (temp.equals("L")) {
                    start.update(i, j);
                } else if (temp.equals("B")) {
                    end.update(i, j);
                }
            }
        }

        arr[end.x][end.y] = ".";

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));

        boolean[][] visited = new boolean[10][10];

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            Point now = node.point;

            visited[now.x][now.y] = true;

            if (now.x == end.x && now.y == end.y) {
                System.out.println(node.count - 1);
                break;
            }

            if (now.x - 1 >= 0 && arr[now.x - 1][now.y].equals(".") && !visited[now.x - 1][now.y]) {
                visited[now.x - 1][now.y] = true;
                queue.add(new Node(new Point(now.x - 1, now.y), node.count + 1));
            }

            if (now.x + 1 < 10 && arr[now.x + 1][now.y].equals(".") && !visited[now.x + 1][now.y]) {
                visited[now.x + 1][now.y] = true;
                queue.add(new Node(new Point(now.x + 1, now.y), node.count + 1));
            }

            if (now.y - 1 >= 0 && arr[now.x][now.y - 1].equals(".") && !visited[now.x][now.y - 1]) {
                visited[now.x][now.y - 1] = true;
                queue.add(new Node(new Point(now.x, now.y - 1), node.count + 1));
            }

            if (now.y + 1 < 10 && arr[now.x][now.y + 1].equals(".") && !visited[now.x][now.y + 1]) {
                visited[now.x][now.y + 1] = true;
                queue.add(new Node(new Point(now.x, now.y + 1), node.count + 1));
            }


        }

    }

    public static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void update(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Node {
        Point point;
        int count;

        public Node(Point point, int count) {
            this.point = point;
            this.count = count;
        }
    }
}