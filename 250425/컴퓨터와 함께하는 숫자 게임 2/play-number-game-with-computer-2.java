import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        Long[] arr = new Long[m];
        for (int i = 1; i < m + 1; i++) {
            arr[i - 1] = (long) i;
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = a; i <= b; i++) {
            min = Math.min(min, binarySearch(arr, i));
            max = Math.max(max, binarySearch(arr, i));
        }

        System.out.println(min + " " + max);
    }

    public static int binarySearch(Long[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left <= right) {
            count++;
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }
}
