import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] remains = new int[b];

        while (a > 0) {
            remains[a % b] += 1;
            a /= b;
        }

        int sum = 0;

        for (int i = 0; i < b; i++) {
            sum += remains[i] * remains[i];
        }

        System.out.println(sum);
    }
}