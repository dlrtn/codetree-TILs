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
            int j = n - 1;
            while (j > i && (a[i] < 0 || Math.abs(a[i] + a[j]) <= min)) {
                min = Math.min(Math.abs(a[i] + a[j]), min);
                j--;
            }
        }

        System.out.println(min);
    }
}
