import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[201][201];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 100;
            int y1 = Integer.parseInt(st.nextToken()) + 100;

            for (int x = x1; x < x1 + 8; x++) {
                for (int y = y1; y < y1 + 8; y++) {
                    arr[x][y] = 1;
                }
            }
        }

        System.out.println(Arrays.stream(arr).flatMapToInt(Arrays::stream).filter(i -> i == 1).count());
    }
}