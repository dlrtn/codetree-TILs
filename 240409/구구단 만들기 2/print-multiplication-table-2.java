import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= 8; i+=2) {
            for (int j = b; j >= a; j--) {
                System.out.printf("%d * %d = %d", j, i, i * j);
                if (j != a) {
                    System.out.print(" / ");
                }
            }
            System.out.println();
        }
    }
}