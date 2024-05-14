import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        System.out.println(recursive(n));

    }

    public static int recursive(int n) {
        if (n < 10) {
            return n * n;
        }
        return (int) Math.pow(n % 10, 2) + recursive(n / 10);
    }

}