import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] ints = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 3; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        dp[1][1] = ints[0];


        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 3; j++) {
                if (j - 1 < 0) {
                    dp[i][j] = dp[i - 2][j] + ints[i - 1];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 2][j]) + ints[i - 1];
            }
        }

        int max = 0;
        for (int i = 0; i <= 3; i++) {
            max = Math.max(max, dp[n][i]);
        }

        System.out.println(max);
    }
}