import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

    public static int count = 0;

    public static int answer = 0;

    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[1001];

        dp[0] = 0;
        dp[1] = 2;
        dp[2] = 7;


        for (int i = 3; i <= 1000; i++) {
            dp[i] = (4 * dp[i - 1] + 2 * dp[i - 2]) % 1000000007;
        }

        System.out.println(dp[n]);
    }
}