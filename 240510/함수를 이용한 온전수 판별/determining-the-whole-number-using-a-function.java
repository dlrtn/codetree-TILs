import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i % 2 != 0 && i % 10 != 5
                    && !(i % 3 == 0 && i % 9 != 0)) {
                count++;
            }
        }

        System.out.println(count);
    }

}