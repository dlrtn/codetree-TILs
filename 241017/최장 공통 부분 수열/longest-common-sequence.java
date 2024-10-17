import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String b = st.nextToken();

        int[][] dp = new int[a.length()][b.length()];
        dp[0][0] = a.charAt(0) == b.charAt(0) ? 1 : 0;

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                        continue;
                    }
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 0;
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[a.length() - 1][b.length() - 1]);

    }
}