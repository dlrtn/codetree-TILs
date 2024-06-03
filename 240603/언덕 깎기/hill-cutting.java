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

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        int answer = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) { // 최소 값이 i인 경우
            int sum = 0;
            int large = i + 17;
            for (int j = 0; j < n; j++) { // 해당 높이
                if (arr[j] < i || arr[j] > large) {
                    sum += (int) Math.pow(Math.min(Math.abs(arr[j] - i), Math.abs(arr[j] - large)), 2);
                }
            }

            answer = Math.min(answer, sum);
        }

        System.out.println(answer);
    }
}