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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        int maxExpanse = Integer.MAX_VALUE;
        for (int i = min; i <= max - k; i++) {
            int m = i + k;

            int expanse = 0;
            for (int j = 0; j < n; j++) {
                if (Math.abs(arr[j] - i) > k || Math.abs(arr[j] - m) > k) {
                    expanse += Math.min(Math.abs(arr[j] - i), Math.abs(arr[j] - m));
                }
            }

            maxExpanse = Math.min(maxExpanse, expanse);
        }

        System.out.println(maxExpanse);
    }

}