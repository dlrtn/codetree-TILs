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

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        // 각 행에 행복한 수열이 몇개 있는지 체크
        for (int i = 0; i < n; i++) {
            int nowNum = 0;
            int count = 0;
            int maxCount = 0;
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    nowNum = arr[i][j];
                    count = 1;
                } else if (arr[i][j] == nowNum) {
                    count++;
                } else {
                    nowNum = arr[i][j];
                    count = 1;
                }

                maxCount = Math.max(maxCount, count);
            }

            if (maxCount >= m) {
                sum++;
            }
        }

        for (int i = 0; i < n; i++) {
            int nowNum = 0;
            int count = 0;
            int maxCount = 0;
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    nowNum = arr[j][i];
                    count = 1;
                } else if (arr[j][i] == nowNum) {
                    count++;
                } else {
                    nowNum = arr[j][i];
                    count = 1;
                }

                maxCount = Math.max(maxCount, count);
            }

            if (maxCount >= m) {
                sum++;
            }
        }

        System.out.println(sum);
    }
}