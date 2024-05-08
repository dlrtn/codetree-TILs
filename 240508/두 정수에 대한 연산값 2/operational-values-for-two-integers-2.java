import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(
                add10ToSmallNumber(Math.min(a, b)) + " " + multiple2ToBigNumber(Math.max(a, b)));
    }

    public static int add10ToSmallNumber(int smallNumber) {
        return smallNumber + 10;
    }

    public static int multiple2ToBigNumber(int bigNumber) {
        return bigNumber * 2;
    }

}