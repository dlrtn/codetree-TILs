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

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            System.out.println(upperBound(arr, a, arr.length) - lowerBound(arr, a, arr.length));
        }
    }

    private static int upperBound(int[] arr, int targetNumber, int n) {
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
