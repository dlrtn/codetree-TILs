import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());

            int lowerBound = lowerBound(arr, a, n);
            int upperBound = upperBound(arr, a, n);

            if (lowerBound == upperBound) {
                System.out.println(-1);
            } else {
                System.out.println(lowerBound + 1);
            }
        }
    }

    public static int upperBound(int[] arr, int targetNumber, int n) {
        int left = 0;
        int right = n - 1;
        int minIdx = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > targetNumber) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }

        return minIdx;
    }

    public static int lowerBound(int[] arr, int targetNumber, int n) {
        int left = 0;
        int right = n - 1;
        int minIdx = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= targetNumber) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }

        return minIdx;
    }
}
