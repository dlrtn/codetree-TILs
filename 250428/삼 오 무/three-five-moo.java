import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        System.out.println(solve(n));
    }


    public static int solve(int n) {
        int result = 1;
        int count = 0;
        while (true) {
            if (result % 3 != 0 && result % 5 != 0) {
                count++;
            }

            if (count == n) {
                return result;
            }
            
            result++;
        }
    }
}
