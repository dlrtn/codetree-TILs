import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> beautifuls = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            beautifuls.add(new LinkedList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for (int j = s - 1; j < e; j++) {
                beautifuls.get(j).add(v);
            }
        }
        
        int[] dp = new int[m + 1];
        for (int i = 1; i < m + 1; i++) {
            int max = 0;
            for (int v : beautifuls.get(i - 1)) {
                if (max <= Math.abs(dp[i - 1] - v)) {
                    max = v;
                }
            }
            dp[i] = max;
        }

        int sum = 0;
        for (int i = 2; i < m  + 1; i++) {
            sum += Math.abs(dp[i] - dp[i - 1]);
        }

        System.out.println(sum);
    }
}