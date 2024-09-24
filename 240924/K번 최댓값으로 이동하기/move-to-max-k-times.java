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

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        Pair start = new Pair(x - 1, y - 1);

        for (int i = 0; i < k; i++) {
            bfs(graph, start, graph[start.x][start.y]);

            int max = Integer.MIN_VALUE;
            Pair next = start;

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (visited[j][l] && graph[j][l] > max && graph[j][l] < graph[start.x][start.y]) {
                        max = graph[j][l];
                        next = new Pair(j, l);
                    }
                }
            }

            start = next;
            visited = new boolean[n][n];
        }

        System.out.println(start.x + 1 + " " + (start.y + 1));
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
                        && graph[nx][ny] < startValue) {
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
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