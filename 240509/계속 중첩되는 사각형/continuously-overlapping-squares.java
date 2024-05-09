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
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int startX = x1 + 100;
            int startY = y1 + 100;
            int endX = x2 + 100;
            int endY = y2 + 100;
            if (i % 2 == 0) {
                for (int j = startY; j < endY; j++) {
                    for (int k = startX; k < endX; k++) {
                        arr[j][k] = 0;
                    }
                }
            } else {
                for (int j = startY; j < endY; j++) {
                    for (int k = startX; k < endX; k++) {
                        arr[j][k] = 1;
                    }
                }
            }
        }

        System.out.println(Arrays.stream(arr).flatMapToInt(Arrays::stream).sum());

    }


}