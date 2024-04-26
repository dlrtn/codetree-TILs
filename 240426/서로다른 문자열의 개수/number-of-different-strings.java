import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        System.out.println(combination(n * 2, n) / (n + 1));

    }

    public static int combination(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }
        return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}