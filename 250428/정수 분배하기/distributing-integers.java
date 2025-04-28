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
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }


        int result = distributionInteger(a, n, m);

        if (result == Integer.MIN_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }

    public static int distributionInteger(int[] a, int n, int m) {
        int left = 1;
        int right = Arrays.stream(a).max().getAsInt();
        int result = Integer.MIN_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(a, n, m, mid)) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int[] a, int n, int m, int mid) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += a[i] / mid;
        }
        return count >= m;
    }
}
