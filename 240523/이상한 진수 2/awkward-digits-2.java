import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        int[] arr = Arrays.stream(n.split("")).mapToInt(Integer::parseInt).toArray();

        boolean isFirstZero = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && !isFirstZero) {
                isFirstZero = true;
                arr[i] = 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[arr.length - i - 1] * Math.pow(2, i);
        }

        System.out.println(sum);


    }

}