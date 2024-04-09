import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[10];
        
        arr[0] = a;
        arr[1] = b;

        for (int i = 2; i < 10; i++) {
            arr[i] = arr[i - 2] * 2 + arr[i - 1];
        }

        Arrays.stream(arr).forEach((c) -> {
            System.out.print(c + " ");
        });

    }
}