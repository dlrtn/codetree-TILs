import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        for (int i = 0; i < 1000001; i++) {
            if (i == 0) {
                continue;
            } else if (arr[i] == 1) {
                arr[i] += arr[i - 1];
            } else {
                arr[i] = arr[i - 1];
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0) {
                System.out.println(arr[b]);
            } else {
                System.out.println(arr[b] - arr[a - 1]);
            }
        }
    }
}
