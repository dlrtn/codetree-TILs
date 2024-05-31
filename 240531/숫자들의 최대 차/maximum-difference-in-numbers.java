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
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        arr = Arrays.stream(arr).sorted().toArray();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int diff = arr[j + i] - arr[j];

                if (diff <= k) {
                answer = Math.max(answer, i + 1);
                }
            }
        }

        System.out.println(answer);
    }
}