import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] numbers = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] cummulativeSum = new int[n + 1][n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                cummulativeSum[i][j] = cummulativeSum[i - 1][j] + cummulativeSum[i][j - 1] - cummulativeSum[i - 1][j - 1] + numbers[i][j];
            }
        }

        for (int i = 1; i < n - k + 1; i++) {
            for (int j = 1; j < n - k + 1; j++) {
                int sum = cummulativeSum[i + k][j + k] - cummulativeSum[i][j + k] - cummulativeSum[i + k][j] + cummulativeSum[i][j];
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
    }
}