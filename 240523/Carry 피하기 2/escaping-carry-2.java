import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int a = arr[i];
                    int b = arr[j];
                    int c = arr[k];
                    boolean isCarry = false;
                    for (int l = 0; l < 5; l++) {
                        if (isCarry(a % 10, b % 10, c % 10)) {
                            isCarry = true;
                            break;
                        }
                        a /= 10;
                        b /= 10;
                        c /= 10;
                    }
                    if (!isCarry) {
                        count = Math.max(count, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }

        if (count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    public static boolean isCarry(int a, int b, int c) {
        return a + b + c >= 10;
    }
}