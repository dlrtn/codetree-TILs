import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(recursive(0, 0));
    }

    private static int recursive(int n, int maxIndex) {
        if (n == arr.length) {
            return arr[maxIndex];
        }

        if (arr[n] > arr[maxIndex]) {
            maxIndex = n;
        }
        return recursive(n + 1, maxIndex);
    }
}