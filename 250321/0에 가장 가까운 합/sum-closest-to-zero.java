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

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        a = Arrays.stream(a).sorted().toArray();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int j = i;
            while (j < n - 1 && Math.abs(a[i] + a[j + 1]) <= min) {
                min = Math.abs(a[i] + a[j + 1]);
                j++;
            }
        }

        System.out.println(min);
    }
}
