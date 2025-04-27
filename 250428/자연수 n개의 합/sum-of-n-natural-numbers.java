import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());

        System.out.println(parametricSearch(n));
    }

    public static long parametricSearch(long n) {
        long l = 0;
        long r = n;

        while (l < r) {
            long mid = (l + r) / 2;

            long sum = calculateSum(mid);

            if (sum > n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public static long calculateSum(long n) {
        long sum = 0;

        if (n % 2 == 0) {
            sum = (n / 2) * (n + 1);
        } else {
            sum = ((n + 1) / 2) * n;
        }

        return sum;
    }
}
