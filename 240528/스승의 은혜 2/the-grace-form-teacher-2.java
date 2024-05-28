import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] ps = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            ps[i] = p;
        }

        ps = Arrays.stream(ps).sorted().toArray();

        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j && sum + ps[j] / 2 <= b) {
                    sum += ps[j] / 2;
                    count++;
                } else if (sum + ps[j] <= b) {
                    sum += ps[j];
                    count++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);


    }
}