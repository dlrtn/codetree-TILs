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
            for (int x = 0; x < n - i; x++) {
                System.out.print("*");
            }
            for (int y = 0; y < i * 2; y++) {
                System.out.print(" ");
            }
            for (int z = 0; z < n - i; z++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}