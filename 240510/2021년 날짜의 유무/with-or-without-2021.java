import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        switch (M) {
            case 1:
                D -= 31;
                break;
            case 2:
                D -= 28;
                break;
            case 3:
                D -= 31;
                break;
            case 4:
                D -= 30;
                break;
            case 5:
                D -= 31;
                break;
            case 6:
                D -= 30;
                break;
            case 7:
                D -= 31;
                break;
            case 8:
                D -= 31;
                break;
            case 9:
                D -= 30;
                break;
            case 10:
                D -= 31;
                break;
            case 11:
                D -= 30;
                break;
            case 12:
                D -= 31;
                break;
            default:
                break;

        }

        if (D > 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

}