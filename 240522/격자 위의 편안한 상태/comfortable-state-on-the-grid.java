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

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            r -= 1;
            c -= 1;

            arr[r][c] = 1;

            int count = 0;
            if (r - 1 >= 0 && arr[r - 1][c] == 1) {
                count++;
            }
            if (r + 1 < n && arr[r + 1][c] == 1) {
                count++;
            }
            if (c - 1 >= 0 && arr[r][c - 1] == 1) {
                count++;
            }
            if (c + 1 < n && arr[r][c + 1] == 1) {
                count++;
            }

            if (count == 3) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }
    }

}