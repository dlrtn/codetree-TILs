import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (!arrange(check, num, m)) {
                break;
            }
        }

        int count = 0;
        for (int i = 1; i <= m; i++) {
            if (check[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean arrange(boolean[] check, int num, int m) {
        for (int i = num; i >= 1; i--) {
            if (!check[i]) {
                check[i] = true;

                return true;
            }
        }
        return false;
    }
}
