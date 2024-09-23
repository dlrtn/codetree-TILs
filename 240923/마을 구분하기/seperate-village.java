import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static boolean[][] vistied;
    public static int[][] graph;
    public static int n;

    public static int[] dx = {0, 1, -1, 0};
    public static int[] dy = {1, 0, 0, -1};

    public static int count = 1;

    public static List<Integer> villageSize = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        vistied = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    dfs(i, j);
                    villageSize.add(count);
                    count = 1;
                }
            }
        }

        System.out.println(villageSize.size());
        villageSize.stream().sorted().forEach(System.out::println);
    }

    public static void dfs(int y, int x) {
        graph[y][x] = 0;
        vistied[y][x] = true;

        for (int k = 0; k < 4; k++) {
            if ((y + dy[k] < n && x + dx[k] < n && y + dy[k] >= 0 && x + dx[k] >= 0)
                    && graph[y + dy[k]][x + dx[k]] == 1 && !vistied[y
                    + dy[k]][x + dx[k]]) {
                vistied[y + dy[k]][x + dx[k]] = true;
                dfs(y + dy[k], x + dx[k]);
                count++;
            }
        }
    }
}