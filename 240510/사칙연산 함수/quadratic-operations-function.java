import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        String c = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        switch (c) {
            case "+":
                System.out.printf("%d + %d = %d", a, b, add(a, b));
                break;
            case "-":
                System.out.printf("%d - %d = %d", a, b, sub(a, b));
                break;
            case "*":
                System.out.printf("%d * %d = %d", a, b, mul(a, b));
                break;
            case "/":
                System.out.printf("%d / %d = %d", a, b, div(a, b));
                break;
            default:
                System.out.println("False");
                break;
        }

    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) {
        return a / b;
    }

}