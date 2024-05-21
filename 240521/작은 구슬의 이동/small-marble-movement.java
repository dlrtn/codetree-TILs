import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String d = st.nextToken();

        for (int i = 0; i < t; i++) {
            if (d.equals("L")) {
                if (c - 1 == 0) {
                    d = "R";
                } else {
                    c--;
                }
            } else if (d.equals("R")) {
                if (c + 1 == n) {
                    d = "L";
                } else {
                    c++;
                }
            } else if (d.equals("U")) {
                if (r - 1 == 0) {
                    d = "D";
                } else {
                    r--;
                }
            } else if (d.equals("D")) {
                if (r + 1 == n) {
                    d = "U";
                } else {
                    r++;
                }
            }
        }

        System.out.println(r + " " + c);
    }

}