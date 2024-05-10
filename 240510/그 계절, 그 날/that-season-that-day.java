import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean isLeapYear = false;
        if (y % 4 == 0 && y % 100 == 0 && y % 400 == 0) {
            isLeapYear = true;
        } else if (y % 4 == 0 && y % 100 != 0) {
            isLeapYear = true;
        }

        boolean isValidDate = false;
        if (m == 1 && d <= 31) {
            isValidDate = true;
        } else if (m == 2 && d <= 29) {
            if (isLeapYear && d <= 29) {
                isValidDate = true;
            } else if (!isLeapYear && d <= 28) {
                isValidDate = true;
            }
        } else if (m == 3 && d <= 31) {
            isValidDate = true;
        } else if (m == 4 && d <= 30) {
            isValidDate = true;
        } else if (m == 5 && d <= 31) {
            isValidDate = true;
        } else if (m == 6 && d <= 30) {
            isValidDate = true;
        } else if (m == 7 && d <= 31) {
            isValidDate = true;
        } else if (m == 8 && d <= 31) {
            isValidDate = true;
        } else if (m == 9 && d <= 30) {
            isValidDate = true;
        } else if (m == 10 && d <= 31) {
            isValidDate = true;
        } else if (m == 11 && d <= 30) {
            isValidDate = true;
        } else if (m == 12 && d <= 31) {
            isValidDate = true;
        }

        if (!isValidDate) {
            System.out.println(-1);
        } else {
            if (m >= 3 && m <= 5) {
                System.out.println("Spring");
            } else if (m >= 6 && m <= 8) {
                System.out.println("Summer");
            } else if (m >= 9 && m <= 11) {
                System.out.println("Fall");
            } else {
                System.out.println("Winter");
            }
        }
    }

}