import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[n * n];
        for (int i = 0; i < m; i++) {
            for (int z = 0; z < n * n; z++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (z + 1 == map[j][k] && !visited[z]) {
                            int maxIndex = 0;
                            int maxNumber = 0;
                            for (int l = 0; l < 8; l++) {
                                int dj = j + dy[l];
                                int dk = k + dx[l];

                                if (dj < 0 || dj >= n || dk < 0 || dk >= n) {
                                    continue;
                                }

                                if (maxNumber < map[dj][dk]) {
                                    maxIndex = l;
                                    maxNumber = map[dj][dk];
                                }
                            }

                            int temp = map[j + dy[maxIndex]][k + dx[maxIndex]];
                            map[j + dy[maxIndex]][k + dx[maxIndex]] = map[j][k];
                            map[j][k] = temp;

                            visited[z] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}