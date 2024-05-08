import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int mul = 1;
        for (int i = 0; i < n; i++) {
            mul *= arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                mul /= gcd(Math.max(arr[i], arr[j]), Math.min(arr[i], arr[j]));
            }
        }

        System.out.println(mul);
    }

    public static int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }

        return gcd(m, n % m);
    }
}