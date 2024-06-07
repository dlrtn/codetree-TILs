import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        int answer = 0;

        if (Math.abs(x - y) == 1) {
            answer = Math.abs(y - z);
        } else if (Math.abs(y - z) == 1) {
            answer = Math.abs(x - y);
        } else {
            answer = Math.min(Math.abs(x - y), Math.abs(y - z));
        }

        if (answer > 2) {
            System.out.println(2);
        } else if (answer == 1) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}