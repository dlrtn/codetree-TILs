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

        st = new StringTokenizer(br.readLine());

        String n = st.nextToken();

        int[] arr = Arrays.stream(n.split("")).mapToInt(Integer::parseInt).toArray();
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num += Math.pow(a, arr.length - i - 1) * arr[i];
        }

        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            sb.append(num % b);
            num /= b;
        }

        System.out.println(sb.reverse());
    }

}