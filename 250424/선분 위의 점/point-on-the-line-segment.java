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

        arr = java.util.Arrays.stream(arr).sorted().toArray();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(upperBound(arr, end, n) - lowerBound(arr, start, n));
        }
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

    public static int upperBound(int[] arr, int targetNumber, int n) {
        int left = 0;
        int right = n - 1;
        int maxIdx = n;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > targetNumber) {
                right = mid - 1;
                maxIdx = Math.min(maxIdx, mid);
            } else {
                left = mid + 1;
            }
        }

        return maxIdx;
    }
}
