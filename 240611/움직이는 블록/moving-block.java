import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sum += num;
        }

        int avg = sum / n;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > avg) {
                count += arr[i] - avg;
            }
        }
        
        System.out.println(count);
    }
}