import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        // 가로일 때
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 2; j++) {
                int count = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];

                answer = Math.max(answer, count);
            }
        }

        // 세로일 때
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && arr[j][i] == 1) {
                    int count = arr[i][j] + arr[i + 1][j] + arr[i + 2][j];

                    answer = Math.max(answer, count);
                }

            }
        }

        System.out.println(answer);
    }
}