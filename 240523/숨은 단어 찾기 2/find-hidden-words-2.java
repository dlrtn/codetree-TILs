import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] map = new String[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] temp = st.nextToken().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = temp[j];
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 가로
                if (j - 1 >= 0 && j + 1 < m) {
                    if (map[i][j - 1].equals("L") && map[i][j].equals("E") && map[i][j + 1].equals("E")) {
                        count++;
                    }
                    if (map[i][j - 1].equals("E") && map[i][j].equals("E") && map[i][j + 1].equals("L")) {
                        count++;
                    }
                }

                // 세로
                if (i - 1 >= 0 && i + 1 < n) {
                    if (map[i - 1][j].equals("L") && map[i][j].equals("E") && map[i + 1][j].equals("E")) {
                        count++;
                    }
                    if (map[i - 1][j].equals("E") && map[i][j].equals("E") && map[i + 1][j].equals("L")) {
                        count++;
                    }
                }

                // 대각선
                if (i - 1 >= 0 && i + 1 < n && j - 1 >= 0 && j + 1 < m) {
                    if (map[i - 1][j - 1].equals("L") && map[i][j].equals("E") && map[i + 1][j + 1].equals("E")) {
                        count++;
                    }
                    if (map[i - 1][j - 1].equals("E") && map[i][j].equals("E") && map[i + 1][j + 1].equals("L")) {
                        count++;
                    }
                    if (map[i - 1][j + 1].equals("L") && map[i][j].equals("E") && map[i + 1][j - 1].equals("E")) {
                        count++;
                    }
                    if (map[i - 1][j + 1].equals("E") && map[i][j].equals("E") && map[i + 1][j - 1].equals("L")) {
                        count++;
                    }
                }
            }

        }

        System.out.println(count);

    }
}