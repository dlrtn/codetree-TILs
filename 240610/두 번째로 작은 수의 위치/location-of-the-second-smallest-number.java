import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Arrays.stream(arr).min().getAsInt();
        if (Arrays.stream(arr).allMatch(i -> i == min)) {
            System.out.println(-1);
            return;
        }
        int secondMin = Arrays.stream(arr).filter(i -> i != min).min().getAsInt();

        if (Arrays.stream(arr).filter(i -> i != min).count() > 1) {
            System.out.println(-1);
            return;
        }

        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == secondMin) {
                answer = i + 1;
                break;
            }
        }

        System.out.println(answer);
    }
}