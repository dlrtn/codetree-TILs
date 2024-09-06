import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        boolean[][] map = new boolean[n][n];
        map[r][c] = true;

        for (int i = 1; i <= m; i++) {
            boolean[][] temp = new boolean[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    temp[j][k] = map[j][k];
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k]) {
                        for (int l = 0; l < 4; l++) {
                            int nextR = j + ((int) Math.pow(2, i - 1)) * dr[l];
                            int nextC = k + ((int) Math.pow(2, i - 1)) * dc[l];

                            if ((nextR < n && nextR >= 0) && (nextC < n && nextC >= 0)) {
                                temp[nextR][nextC] = true;
                            }
                        }
                    }
                }
            }

            map = temp;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}