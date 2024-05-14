import static java.lang.System.exit;

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
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(arr[0]);
            exit(0);
        }
        
        arr = Arrays.stream(arr).sorted().toArray();

        int mul = lcm(arr[1], arr[0]);
        for (int i = 2; i < n; i++) {
            mul = lcm(arr[i], mul);
        }

        System.out.println(mul);
    }

    public static int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }

        return gcd(m, n % m);
    }

    public static int lcm(int n, int m) {
        return n * m / gcd(n, m);
    }
}