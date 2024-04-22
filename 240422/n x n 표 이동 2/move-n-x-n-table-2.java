import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(bfs(i, j, arr), max);
            }
        }

        System.out.println(max);
    }

    public static class Node {

        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static int bfs(int x, int y, int[][] graph) {
        int count = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 1));

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            int tempX = nowNode.x;
            int tempY = nowNode.y;
            int tempCount = nowNode.count;
            int nowNumber = graph[tempX][tempY];

            if (tempX > 0 && graph[tempX - 1][tempY] > nowNumber) {
                queue.add(new Node(tempX - 1, tempY, tempCount + 1));
            }

            if (tempY > 0 && graph[tempX][tempY - 1] > nowNumber) {
                queue.add(new Node(tempX, tempY - 1, tempCount + 1));
            }

            if (tempX < graph.length - 1 && graph[tempX + 1][tempY] > nowNumber) {
                queue.add(new Node(tempX + 1, tempY, tempCount + 1));
            }

            if (tempY < graph.length - 1 && graph[tempX][tempY + 1] > nowNumber) {
                queue.add(new Node(tempX, tempY + 1, tempCount + 1));
            }

            count = Math.max(tempCount, count);
        }

        return count;
    }
}