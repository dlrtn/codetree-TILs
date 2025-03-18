import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 가능한 구간 중 최대 크기를 구합니다.
        int ans = Integer.MAX_VALUE;

        // 구간을 잡아봅니다.
        int sumVal = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && sumVal < s) {
                sumVal += arr[j];
                j++;
            }

            if (sumVal >= s) {
                ans = Math.min(ans, j - i);
            }

            sumVal -= arr[i];
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
