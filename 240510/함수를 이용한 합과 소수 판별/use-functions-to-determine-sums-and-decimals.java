import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                if (Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum() % 2
                        == 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean isPrime(int i) {
        if (i == 0) {
            return false;
        }
        for (int j = 2; j <= (int) Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

}