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

        int[] aArr = new int[1000001];
        int[] bArr = new int[1000001];

        int aStart = 1;
        int bStart = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for (int j = 0; j < t; j++) {
                aArr[aStart] += aArr[aStart - 1] + v;
                aStart++;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for (int j = 0; j < t; j++) {
                bArr[bStart] += bArr[bStart - 1] + v;
                bStart++;
            }
        }

        String now = "none";

        int count = 0;

        for (int i = 0; i < 1000001; i++) {
            if (aArr[i] > bArr[i] && !now.equals("a")) {
                if (now.equals("b")) {
                    count++;
                }
                now = "a";
            } else if (aArr[i] < bArr[i] && !now.equals("b")) {
                if (now.equals("a")) {
                    count++;
                }
                now = "b";
            }
        }

        System.out.println(count);
    }

}