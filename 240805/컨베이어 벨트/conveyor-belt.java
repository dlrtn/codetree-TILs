import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] arr = new int[2][n];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < t; i++) {
            arr = swap(arr, n);
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] swap(int[][] arr, int n) {
        int[][] tempArr = new int[2][n];

        int temp1 = arr[0][n - 1];
        int temp2 = arr[1][n - 1];

        for (int i = 1; i < n; i++) {
            tempArr[0][i] = arr[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            tempArr[1][i] = arr[1][i - 1];
        }

        tempArr[1][0] = temp1;
        tempArr[0][0] = temp2;

        return tempArr;
    }
}