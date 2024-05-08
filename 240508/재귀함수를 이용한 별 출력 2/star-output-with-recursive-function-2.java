import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        printStar(n);
        printStar1(1, n);
    }

    public static void printStar(int n) {
        if (n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();

        printStar(n - 1);
    }

    public static void printStar1(int depth, int k) {
        if (depth == k) {
            return;
        }

        for (int i = 0; i < depth; i++) {
            System.out.print("*");
        }
        System.out.println();

        printStar1(depth + 1, k);
    }
}