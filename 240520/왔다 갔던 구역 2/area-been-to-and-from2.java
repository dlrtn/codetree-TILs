import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[2001];

        int start = 1000;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String D = st.nextToken();

            if (D.equals("R")) {
                for (int j = 0; j < x; j++) {
                    arr[start + j]++;
                }
                start += x;
            } else {
                for (int j = 0; j < x; j++) {
                    arr[start - j]++;
                }
                start -= x;
            }
        }

        System.out.println(Arrays.stream(arr).filter(i -> i >= 2).count());
    }
}