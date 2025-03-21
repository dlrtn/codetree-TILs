import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int pow = 0;

        int answer = 0;
        while (n != 0) {
            answer += (n % 10) * Math.pow(2, pow++);
            n /= 10;
        }

        System.out.println(answer);
    }
}