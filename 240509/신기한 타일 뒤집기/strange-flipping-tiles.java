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

        int[] arr = new int[200001];
        int now = 100000;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            if (s.equals("L")) {
                for (int j = 0; j < x; j++) {
                    arr[now - j] = -1;
                }
                now -= x - 1;
            } else {
                for (int j = 0; j < x; j++) {
                    arr[now + j] = 1;
                }
                now += x - 1;
            }
        }

        System.out.print(Arrays.stream(arr).filter((a) -> a == -1).count() + " ");
        System.out.print(Arrays.stream(arr).filter((a) -> a == 1).count() + "\n");
    }

}