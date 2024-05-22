import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int startX = 0;
        int startY = 0;

        int count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            int y = Integer.parseInt(st.nextToken());

            for (int j = 0; j < y; j++) {
                if (x.equals("N")) {
                    startY++;
                } else if (x.equals("S")) {
                    startY--;
                } else if (x.equals("E")) {
                    startX++;
                } else {
                    startX--;
                }
                count++;

                if (startX == 0 && startY == 0) {
                    System.out.println(count);
                    exit(0);
                }
            }

        }

        System.out.println(-1);

    }

}