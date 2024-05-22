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

        int num = 65;

        char[][] answer = new char[n][m];

        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        int x = 0;
        int y = 0;
        int dir = 0;

        for (int i = 0; i < n * m; i++) {
            answer[x][y] = (char) num;
            num++;
            if (num >= 91) {
                num %= 91;
                num += 65;
            }

            if (x + dx[dir] < 0 || x + dx[dir] >= n || y + dy[dir] < 0 || y + dy[dir] >= m
                    || answer[x + dx[dir]][y + dy[dir]] != 0) {
                dir = (dir + 1) % 4;
            }

            x += dx[dir];
            y += dy[dir];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

}