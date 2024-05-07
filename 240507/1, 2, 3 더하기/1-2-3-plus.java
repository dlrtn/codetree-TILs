import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());


        backtracking(n, 0);

        System.out.println(count);
    }

    public static void backtracking(int n, int sum) {
        if (sum >= n) {
            if (sum == n) {
                count++;
            }
            return;
        }

        backtracking(n, sum + 1);
        backtracking(n, sum + 2);
        backtracking(n, sum + 3);
    }

}