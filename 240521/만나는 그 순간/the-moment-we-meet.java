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
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[1001];
        int[] b = new int[1001];

        int aStart = 1;
        int bStart = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String d = st.nextToken();
            int p = Integer.parseInt(st.nextToken());

            for (int j = 0; j < p; j++) {
                if (d.equals("R")) {
                    a[aStart] = a[aStart - 1] + 1;
                } else {
                    a[aStart] = a[aStart - 1] - 1;
                }
                aStart++;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String d = st.nextToken();
            int p = Integer.parseInt(st.nextToken());

            for (int j = 0; j < p; j++) {
                if (d.equals("R")) {
                    b[bStart] = b[bStart - 1] + 1;
                } else {
                    b[bStart] = b[bStart - 1] - 1;
                }
                bStart++;
            }

        }

        for (int i = 1; i < 1001; i++) {
            if (a[i] == b[i]) {
                System.out.println(i);
                exit(0);
            }
        }
        System.out.println(-1);
    }


}