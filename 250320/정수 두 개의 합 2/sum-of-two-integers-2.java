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
        int k = Integer.parseInt(st.nextToken());

        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            list[i] = Integer.parseInt(st.nextToken());
        }

        list = Arrays.stream(list).sorted().toArray();

        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            int sum = list[i];
            int j = i + 1;

            while (j < n && sum + list[j] <= k) {
                count++;
                j++;
            }
        }

        System.out.println(count);
    }
}
