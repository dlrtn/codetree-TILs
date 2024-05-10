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

        if (n % 2 == 0 && Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum() % 5 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }


}