import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        drawDiamond(n);
    }

    public static void drawDiamond(int n) {
        for (int i = 0; i < n * 2; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n - (i / 2); j++) {
                    System.out.print("* ");
                }
            } else {
                for (int j = 0; j <= i / 2; j++) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}