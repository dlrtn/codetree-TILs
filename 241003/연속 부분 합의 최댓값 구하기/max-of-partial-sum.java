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

        int[] ints = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = ints[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + ints[i], ints[i]);
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}