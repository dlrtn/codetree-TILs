import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] arr = new int[3][n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());

            arr[number - 1][i + 1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            arr[0][i] += arr[0][i - 1];
            arr[1][i] += arr[1][i - 1];
            arr[2][i] += arr[2][i - 1];
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            System.out.println((arr[0][r] - arr[0][l - 1]) + " " + (arr[1][r] - arr[1][l - 1]) + " " + (arr[2][r] - arr[2][l - 1]));
        }

    }
}
