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

        int honor = 3;
        // honor == 0, 초기 상태
        // honor == 1, a가 선두인 상태
        // honor == 2, b가 선두인 상태
        // honor == 3, 둘 다 선두인 상태

        int count = 0;

        for (int i = 0; i < Math.max(aStart, bStart); i++) {
            if (aArr[i] > bArr[i] && honor != 1) {
                count++;
                honor = 1;
            } else if (aArr[i] < bArr[i] && honor != 2) {
                count++;
                honor = 2;
            } else if (aArr[i] == bArr[i] && honor != 3) {
                count++;
                honor = 3;
            }
        }

        System.out.println(count);
    }

}