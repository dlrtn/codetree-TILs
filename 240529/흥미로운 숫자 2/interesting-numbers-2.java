import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = x; i <= y; i++) {
            if (isOdd(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isOdd(int n) {
        String str = String.valueOf(n);

        int[] arr = new int[10];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - '0']++;
        }

        for (int i : arr) {
            if (i == str.length() - 1) {
                return true;
            }
        }
        return false;
    }
}