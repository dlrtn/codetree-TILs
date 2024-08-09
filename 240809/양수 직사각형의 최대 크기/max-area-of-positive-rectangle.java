import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        int count = 0;
                        for (int o = i; o <= k; o++) {
                            for (int p = j; p <= l; p++) {
                                if (map[o][p] > 0) {
                                    count++;
                                }
                            }
                        }

                        if (count == (k - i + 1) * (l - j + 1)) {
                            answer = Math.max(answer, count);
                        }
                    }
                }
            }
        }

        if (answer == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }
}