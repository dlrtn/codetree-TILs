import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (Math.abs(a - i) <= 2) {
                answer += (int) Math.pow(n, 2);
                continue;
            }
            for (int j = 1; j <= n; j++) {
                if (Math.abs(b - j) <= 2) {
                    answer += n;
                    continue;
                }
                for (int k = 1; k <= n; k++) {
                    if (Math.abs(c - k) <= 2) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}