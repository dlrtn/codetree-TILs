import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            arr[index] += count;
        }

        int count = 0;
        for (int i = 0; i <= 100 - 2 * k; i++) {
            int sum = 0;
            for (int j = i; j <= i + 2 * k; j++) {
                sum += arr[j];
            }
            count = Math.max(count, sum);
        }

        System.out.println(count);

    }


}