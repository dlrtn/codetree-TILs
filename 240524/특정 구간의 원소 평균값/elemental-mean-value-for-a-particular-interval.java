import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = n;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int sum = 0;
                for (int k = 0; k <= i; k++) {
                    sum += arr[j + k];
                }
                double avg = (double) sum / i;

                for (int k = 0; k <= i; k++) {
                    if (arr[j + k] == avg) {
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }

}