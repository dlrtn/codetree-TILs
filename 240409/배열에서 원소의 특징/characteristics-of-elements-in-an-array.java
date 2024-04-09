import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int temp = -1;
        for (int i = 0; i < 10; i++) {
            int j = Integer.parseInt(st.nextToken());
            if (j % 3 == 0) {
                System.out.print(temp + " ");
                return;
            }
            temp = j;
        }

    }
}