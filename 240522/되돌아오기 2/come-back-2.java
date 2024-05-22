import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        String[] arr = str.split("");

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int startX = 0;
        int startY = 0;

        int direction = 0;
        int count = 0;

        for (String string : arr) {
            if (string.equals("F")) {
                startX += dx[direction];
                startY += dy[direction];
            } else {
                switch (string) {
                    case "L":
                        direction += 3;
                        direction %= 4;
                        break;
                    case "R":
                        direction += 1;
                        direction %= 4;
                        break;
                }
            }

            count++;
            if (startX == 0 && startY == 0 && count != 1) {
                System.out.println(count);
                exit(0);
            }
        }
        System.out.println(-1);
    }

}