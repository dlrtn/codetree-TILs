import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] clothes = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            clothes[i][0] = Integer.parseInt(st.nextToken()) - 1;
            clothes[i][1] = Integer.parseInt(st.nextToken()) - 1;
            clothes[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            if (clothes[i][0] == 0) {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (clothes[j][0] <= i && clothes[j][1] >= i) {
                    for (int k = 0; k < n; k++) {
                        if (dp[i - 1][k] == -1) {
                            continue;
                        }
                        dp[i][j] = Math.max(dp[i][j],
                                dp[i - 1][k] + Math.abs(clothes[k][2] - clothes[j][2]));
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[m - 1][i]);
        }

        System.out.println(max);

    }
}