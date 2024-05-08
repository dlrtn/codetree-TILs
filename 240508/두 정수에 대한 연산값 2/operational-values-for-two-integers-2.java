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

        if (a > b) {
            a = multiple2ToBigNumber(a);
            b = add10ToSmallNumber(b);
        } else {
            a = add10ToSmallNumber(a);
            b = multiple2ToBigNumber(b);
        }

        System.out.println(a + " " + b);
    }

    public static int add10ToSmallNumber(int smallNumber) {
        return smallNumber + 10;
    }

    public static int multiple2ToBigNumber(int bigNumber) {
        return bigNumber * 2;
    }

}