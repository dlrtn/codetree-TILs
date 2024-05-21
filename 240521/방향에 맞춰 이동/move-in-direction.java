import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());

            if (a.equals("N")) {
                startY += b;
            } else if (a.equals("S")) {
                startY -= b;
            } else if (a.equals("E")) {
                startX += b;
            } else if (a.equals("W")) {
                startX -= b;
            }
        }

        System.out.println(startX + " " + startY);
    }

}