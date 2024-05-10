import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());

        if (y % 100 == 0 && y % 400 != 0) {
            System.out.println("false");
        } else if (y % 4 == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }



}