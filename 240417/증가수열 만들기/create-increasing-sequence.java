import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                count += arr[i] - arr[i + 1] + 1;
                arr[i] = arr[i + 1] - 1;
            }
        }

        System.out.println(count);
    }
}