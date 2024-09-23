import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static boolean[] vistied;
    public static boolean[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new boolean[n][n];
        vistied = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x - 1][y - 1] = true;
            graph[y - 1][x - 1] = true;
        }

        dfs(0, n);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vistied[i]) {
                count++;
            }
        }

        System.out.println(count - 1);
    }

    public static void dfs(int node, int n) {
        for (int i = 0; i < n; i++) {
            if (graph[node][i] && !vistied[i]) {
                vistied[i] = true;
                dfs(i, n);
            }
        }
    }
}