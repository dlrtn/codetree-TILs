import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int firstCount = B - A;
        int secondCount = Math.abs(A - x) + Math.abs(B - y);
        int thirdCount = Math.abs(A - y) + Math.abs(B - x);

        System.out.println(Math.min(firstCount, Math.min(secondCount, thirdCount)));
    }
}