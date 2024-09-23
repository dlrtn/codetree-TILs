import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static boolean[][] vistied;
    public static int[][] graph;
    public static int n, m;

    public static int[] dx = {0, 1};
    public static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        vistied = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        if (vistied[n - 1][m - 1]) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(int y, int x) {
        for (int k = 0; k < 2; k++) {
            if ((y + dy[k] < m && x + dx[k] < n) && graph[y + dy[k]][x + dx[k]] == 1 && !vistied[y
                    + dy[k]][x + dx[k]]) {
                vistied[y + dy[k]][x + dx[k]] = true;
                dfs(y + dy[k], x + dx[k]);
            }
        }
    }
}