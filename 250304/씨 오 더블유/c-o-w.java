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

        String s = st.nextToken();

        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'C') {
                c[i] += 1;
            }
        }

        for (int i = 1; i < n; i++) {
            c[i] += c[i - 1];
        }

        int[] w = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'W') {
                w[i] += 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            w[i] += w[i + 1];
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'O') {
                count += c[i] * w[i];
            }
        }

        System.out.println(count);
    }
}
