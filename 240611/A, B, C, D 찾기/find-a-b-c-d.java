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

        int[] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr = Arrays.stream(arr).sorted().toArray();

        int a = arr[0];
        int b = arr[1];
        int c;
        if (arr[2] == a + b) {
            c = arr[3];
        } else {
            c = arr[2];
        }
        int d = arr[14] - a - b - c;

        System.out.println(a + " " + b + " " + c + " " + d);
    }
}