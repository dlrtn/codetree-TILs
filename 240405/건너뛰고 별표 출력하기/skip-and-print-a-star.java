import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n * 2 - 1; i++) {
            if (i / n == 0) {
                for (int k = 0; k < i + 1; k++) {
                    System.out.print("*");
                }   
                System.out.println();
            } else {
                for (int k = 0; k < n - (i % n + 1); k++) {
                    System.out.print("*");
                }   
                System.out.println();
            }
            System.out.println();
        }
    }
}