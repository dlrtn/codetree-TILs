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

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxNum = 0;
        // | 트로미노일 때, 모든 값 계산
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j < m; j++) {
                maxNum = Math.max(maxNum, arr[i][j] + arr[i + 1][j] + arr[i + 2][j]);
            }
        }

        // - 트로미노일 때, 모든 값 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m - 3; j++) {
                maxNum = Math.max(maxNum, arr[i][j] + arr[i][j + 1] + arr[i][j + 2]);
            }
        }

        // ㅁ 트로미노일 때, 하나씩 빼서 계산
        for (int i = 0; i <= n - 2; i++) {
            for (int j = 0; j <= m - 2; j++) {
                int totalSum = arr[i][j] + arr[i + 1][j] + arr[i][j + 1] + arr[i + 1][j + 1];

                maxNum = Math.max(maxNum, totalSum - arr[i][j]);
                maxNum = Math.max(maxNum, totalSum - arr[i + 1][j]);
                maxNum = Math.max(maxNum, totalSum - arr[i][j + 1]);
                maxNum = Math.max(maxNum, totalSum - arr[i + 1][j + 1]);
            }
        }

        System.out.println(maxNum);
    }
}