import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] arr = new int[2001][2001];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 1000;
            int y1 = Integer.parseInt(st.nextToken()) + 1000;
            int x2 = Integer.parseInt(st.nextToken()) + 1000;
            int y2 = Integer.parseInt(st.nextToken()) + 1000;

            if (i == 0) {
                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        arr[x][y] = 1;
                    }
                }
            }
            if (i == 1) {
                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        arr[x][y] = 0;
                    }
                }
            }
        }

        int minX = 2001;
        int minY = 2001;
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if (arr[i][j] == 1) {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        System.out.println((maxX - minX) * (maxY - minY));
    }
}