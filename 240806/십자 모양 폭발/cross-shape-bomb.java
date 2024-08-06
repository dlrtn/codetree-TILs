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

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 배열에서 r, c 행의 값만큼의 폭탄이 터진다.
        int explosionRowIndex = r - 1;
        int explosionColumnIndex = c - 1;

        int explosionSize = arr[explosionRowIndex][explosionColumnIndex] - 1;
        int explosionStartRowIndex = Math.max(explosionRowIndex - explosionSize, 0);
        int explosionEndRowIndex = Math.min(explosionRowIndex + explosionSize, n - 1);
        int explosionStartColumnIndex = Math.max(explosionColumnIndex - explosionSize, 0);
        int explosionEndColumnIndex = Math.min(explosionColumnIndex + explosionSize, n - 1);

        for (int i = explosionStartRowIndex; i < explosionEndRowIndex + 1; i++) {
            if (i == explosionRowIndex) {
                for (int j = explosionStartColumnIndex; j < explosionEndColumnIndex + 1; j++) {
                    arr[i][j] = 0;
                }
            } else {
                arr[i][explosionColumnIndex] = 0;
            }
        }

        // 중력이 작용한다.
        int[][] answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];

            int nowIndex = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j][i] != 0) {
                    temp[nowIndex++] = arr[j][i];
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                answer[j][i] = temp[n - j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}