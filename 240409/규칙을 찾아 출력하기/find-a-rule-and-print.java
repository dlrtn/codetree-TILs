import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = false;
                if (j == 0) {
                    flag = true;
                } else if (j == n - 1) {
                    flag = true;
                } else if (j < i) {
                    flag = true;
                } else if (i == 0) {
                    flag = true;
                }

                if (flag) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }
}