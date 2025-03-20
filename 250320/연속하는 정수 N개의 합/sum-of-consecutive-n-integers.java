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

        int[] A = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && sum < m) {
                sum += A[j];
                j++;
            }

            if (sum == m) {
                count++;
            }

            sum -= A[i];
        }

        System.out.println(count);
    }
}
