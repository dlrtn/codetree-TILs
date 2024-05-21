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
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            for (int j = 0; j < t; j++) {
                if (d.equals("R")) {
                    aArr[aStart] = aArr[aStart - 1] + 1;
                } else {
                    aArr[aStart] = aArr[aStart - 1] - 1;
                }
                aStart++;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            for (int j = 0; j < t; j++) {
                if (d.equals("R")) {
                    bArr[bStart] = bArr[bStart - 1] + 1;
                } else {
                    bArr[bStart] = bArr[bStart - 1] - 1;
                }
                bStart++;
            }
        }

        if (aStart != bStart) {
            if (aStart > bStart) {
                for (int i = bStart; i < aStart; i++) {
                    bArr[i] = bArr[i - 1];
                }
            } else {
                for (int i = aStart; i < bStart; i++) {
                    aArr[i] = aArr[i - 1];
                }
            }
        }

        int count = 0;
        for (int i = 1; i < Math.max(aStart, bStart); i++) {
            if (aArr[i - 1] != bArr[i - 1] && aArr[i] == bArr[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

}