import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static boolean[][] visited;
    public static int[] dx = {0, 1, -1, 0};
    public static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            bfs(graph, new Pair(x - 1, y - 1));
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void bfs(int[][] graph, Pair start) {
        Queue<Pair> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                if (x + dx[i] < 0 || x + dx[i] >= graph.length || y + dy[i] < 0
                        || y + dy[i] >= graph[0].length) {
                    continue;
                } else if (!visited[x + dx[i]][y + dy[i]] && graph[x + dx[i]][y + dy[i]] == 0) {
                    q.add(new Pair(x + dx[i], y + dy[i]));
                    visited[x + dx[i]][y + dy[i]] = true;
                }
            }
        }
    }


    public static class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}