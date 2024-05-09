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

        int[] arr = new int[101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for (int j = 0; j < x; j++) {
                if (s.equals("L")) {
                    arr[j] = -1;
                } else  {
                    arr[j] = 1;
                }
            }
        }

        System.out.print(Arrays.stream(arr).filter((a) -> a == -1).count() + " ");
        System.out.print(Arrays.stream(arr).filter((a) -> a == 1).count());

    }

}