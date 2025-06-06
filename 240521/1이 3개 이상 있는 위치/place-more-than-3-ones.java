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
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answerCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (i > 0 && arr[i - 1][j] == 1) {
                    count++;
                }
                if (i < n - 1 && arr[i + 1][j] == 1) {
                    count++;
                }
                if (j > 0 && arr[i][j - 1] == 1) {
                    count++;
                }
                if (j < n - 1 && arr[i][j + 1] == 1) {
                    count++;
                }

                if (count >= 3) {
                    answerCount++;
                }
            }

        }

        System.out.println(answerCount);
    }

}