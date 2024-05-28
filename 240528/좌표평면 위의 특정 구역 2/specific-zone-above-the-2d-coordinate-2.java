import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int minRectangleSize = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                minX = Math.min(minX, x[j]);
                minY = Math.min(minY, y[j]);
                maxX = Math.max(maxX, x[j]);
                maxY = Math.max(maxY, y[j]);
            }

            minRectangleSize = Math.min(minRectangleSize, (maxX - minX) * (maxY - minY));
        }

        System.out.println(minRectangleSize);
    }
}