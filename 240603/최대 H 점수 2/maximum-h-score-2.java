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
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr = Arrays.stream(arr).sorted().toArray();

        int answer = 0;
        for (int i = 0; i < n - l; i++) {
            for (int j = 0; j < l; j++) {
                arr[j + i]++;
            }

            // h 스코어를 구하는 함수
            for (int j = 0; j < 100; j++) {
                answer = Math.max(answer, getHScore(arr, j));
            }

            for (int j = 0; j < l; j++) {
                arr[j + i]--;
            }
        }

        System.out.println(answer);
    }

    public static int getHScore(int[] arr, int h) {
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] >= h) {
                count++;
            }
        }

        if (count >= h) {
            return h;
        }

        return 0;
    }

}