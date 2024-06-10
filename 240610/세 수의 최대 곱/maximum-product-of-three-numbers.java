import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr = Arrays.stream(arr).sorted().toArray();

        // 음음양
        int nenepo = arr[0] * arr[1] * arr[n - 1];
        // 양양양
        int popopo = arr[n - 1] * arr[n - 2] * arr[n - 3];

        // 음음음
        int neneno = arr[0] * arr[1] * arr[2];
        // 음양양
        int nenyen = arr[0] * arr[n - 2] * arr[n - 1];

        System.out.println(Math.max(Math.max(nenepo, popopo), Math.max(neneno, nenyen)));

    }
}