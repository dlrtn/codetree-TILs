import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        if (n % 2 ==0) {
            System.out.println(recursiveEven(n));
        } else {
            System.out.println(recursiveOdd(n));
        
        }

    }

    private static int recursiveEven(int n) {
        if (n == 2) {
            return 2;
        }

        return recursiveEven(n - 2) + n;
    }

    public static int recursiveOdd(int n) {
        if (n == 1) {
            return 1;
        }

        return recursiveOdd(n - 2) + n;
    }

}