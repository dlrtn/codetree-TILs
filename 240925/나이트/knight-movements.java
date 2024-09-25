import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static boolean[][] visited;
    public static int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    public static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    public static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][n];
        distance = new int[n][n];
        visited = new boolean[n][n];

        st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        Pair start = new Pair(r1 - 1, c1 - 1);

        bfs(graph, start);

        if (distance[r2 - 1][c2 - 1] == 0 && (r1 != r2 || c1 != c2)) {
            System.out.println(-1);
        } else {
            System.out.println(distance[r2 - 1][c2 - 1]);
        }
    }

    public static void bfs(int[][] graph, Pair start) {
        Queue<Pair> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            visited[p.x][p.y] = true;

            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < graph.length && ny >= 0 && ny < graph.length
                        && !visited[nx][ny]) {
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

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}