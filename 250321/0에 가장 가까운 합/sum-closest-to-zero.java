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
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            if (i < j)
                min = Math.min(min, Math.abs(a[i] + a[j]));

            while (i < j - 1 && a[i] + a[j] > 0) {
                j--;
                min = Math.min(min, Math.abs(a[i] + a[j]));
            }
        }

        System.out.println(min);
    }
}
