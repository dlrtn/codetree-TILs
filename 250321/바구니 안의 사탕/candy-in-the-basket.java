import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[1000002];

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int candyCount = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            arr[point] += candyCount;
        }

        int max = 0;
        int i = 0, j = 0;
        int count = 0;
        while (j < 1000001) {
            while (j < 1000001 && j - i < 2 * k) {
                count += arr[j];
                j++;
            }

            max = Math.max(max, count);

            count -= arr[i];
            i++;
            j++;

            if (j == 1000002) {
                break;
            }
            count += arr[j];
        }

        System.out.println(max);

    }
}
