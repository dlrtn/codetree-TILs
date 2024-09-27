import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][n];
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][n - 1] = arr[0][n - 1];

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == 0 && j == n - 1) {
                    continue;
                }

                if (j == n - 1) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]) + arr[i][j];
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}