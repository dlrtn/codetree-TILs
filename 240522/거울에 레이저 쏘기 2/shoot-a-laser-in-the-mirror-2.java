import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        String[][] arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.substring(j, j + 1);
            }
        }

        int count = 1;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        start--;

        int direction = 0;
        int i = 0;
        int j = 0;
        switch (start / n) {
            case 0:
                direction = 0;
                i = 0;
                j = start;
                break;
            case 1:
                direction = 3;
                i = n + 1 % n;
                j = n - 1;
                break;
            case 2:
                direction = 1;
                i = n - 1;
                j = start % n;
                break;
            case 3:
                direction = 2;
                i = 0;
                j = n - 1 - start % n;
                break;
        }

        while (true) {
            if (i < 0 || i >= n || j < 0 || j >= n) {
                break;
            }

            if (arr[i][j].equals("/")) {
                i += dx[direction];
                j += dy[direction];

                if (direction == 0) {
                    direction = 3;
                } else if (direction == 1) {
                    direction = 2;
                } else if (direction == 2) {
                    direction = 1;
                } else if (direction == 3) {
                    direction = 0;
                }
            } else if (arr[i][j].equals("\\")) {
                i -= dx[direction];
                j -= dy[direction];

                if (direction == 0) {
                    direction = 3;
                } else if (direction == 1) {
                    direction = 2;
                } else if (direction == 2) {
                    direction = 1;
                } else if (direction == 3) {
                    direction = 0;
                }
            }
            count++;
        }

        System.out.println(count);
    }

}