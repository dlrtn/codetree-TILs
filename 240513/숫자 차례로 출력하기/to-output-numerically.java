import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        recursive(n);
        System.out.println();
        recursivePlus(n);
    }

    public static void recursive(int n) {
        if (n == 0) {
            return;
        }
        recursive(n - 1);
        System.out.print(n + " ");
    }

    public static void recursivePlus(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        recursive(n - 1);
    }

}