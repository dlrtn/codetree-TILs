import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int sum1 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        backtracking(a, b, c, 0);

        System.out.println(sum1);
    }

    public static void backtracking(int a, int b, int c, int sum) {
        if (sum + a > c || sum + b > c) {
            sum1 = Math.max(sum1, sum);

            return;
        }

        backtracking(a, b, c, sum + a);
        backtracking(a, b, c, sum + b);
    }
}