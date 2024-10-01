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

        int[] ints = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = 10000;
            }
        }
        if (m >= ints[0]) {
            dp[0][ints[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                for (int k = 0; k <= m; k++) {
                    if (k - ints[i] < 0) {
                        continue;
                    }

                    dp[i][k] = Math.min(dp[i][k], dp[j][k - ints[i]] + 1);
                }
            }

        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, dp[i][m]);
        }

        if (answer != 10000) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}