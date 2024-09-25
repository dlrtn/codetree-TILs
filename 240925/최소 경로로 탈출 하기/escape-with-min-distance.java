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
    public static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][n];
        distance = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Pair start = new Pair(0, 0);

        bfs(graph, start, graph[start.x][start.y]);

        if (distance[n - 1][n - 1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(distance[n - 1][n - 1]);
        }
    }

    public static void bfs(int[][] graph, Pair start, int startValue) {
        Queue<Pair> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            visited[p.x][p.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < graph.length && ny >= 0 && ny < graph.length && !visited[nx][ny]
                        && graph[nx][ny] == 1) {
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[p.x][p.y] + 1;
                }
            }
        }
    }


    public static class Pair {

        int x;
        int y;
        int count;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.count = 0;
        }
    }

}