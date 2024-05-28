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

        int maxRectangleSize = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {

                    int h = 0;
                    int w = 0;
                    if (x[i] == x[j]) {
                        h = Math.abs(y[i] - y[j]);
                    } else if (x[j] == x[k]) {
                        h = Math.abs(y[j] - y[k]);
                    } else if (x[k] == x[i]) {
                        h = Math.abs(y[k] - y[i]);
                    }

                    if (y[i] == y[j]) {
                        w = Math.abs(x[i] - x[j]);
                    } else if (y[j] == y[k]) {
                        w = Math.abs(x[j] - x[k]);
                    } else if (y[k] == y[i]) {
                        w = Math.abs(x[k] - x[i]);
                    }

                    int rectangleSize = h * w;

                    if (rectangleSize > maxRectangleSize) {
                        maxRectangleSize = rectangleSize;
                    }
                }
            }
        }

        System.out.println(maxRectangleSize);
    }
}