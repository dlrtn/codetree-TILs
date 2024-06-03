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
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] arr2 = new boolean[n];
        int[] arr1 = new int[10000001];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j] && j - i <= k) {
                    arr2[i] = true;
                    arr2[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr2[i]) {
                arr1[arr[i]]++;
            }
        }

        int answer = 0;
        int max = Arrays.stream(arr1).max().getAsInt();
        for (int i = 0; i < 1000001; i++) {
            if (max == arr1[i] && max != 0) {
                answer = i;
            }
        }

        System.out.println(answer);
    }
}