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

        for (int i = n; i > 0; i--) {
            boolean isContinue = false;

            int max = Integer.MIN_VALUE;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] >= i) {
                    if (isContinue) {
                        count++;
                    } else {
                        count = 1;
                        isContinue = true;
                    }
                } else {
                    count = 0;
                    isContinue = false;
                }
                max = Math.max(max, count);
            }

            if (k == max) {
                System.out.println(i);
                break;
            } else if (k < max) {
                System.out.println(i + 1);
                break;
            }

        }
    }
}