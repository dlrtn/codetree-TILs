import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] graph = new int[19][19];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int winner = 0;
        int x = 0, y = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (graph[i][j] == 0) {
                    continue;
                }
                // 가로
                if (j > 2 && j < 17 && graph[i][j - 2] == graph[i][j - 1]
                        && graph[i][j - 1] == graph[i][j]
                        && graph[i][j] == graph[i][j + 1] && graph[i][j + 1] == graph[i][j + 2]) {
                    winner = graph[i][j];
                    x = i + 1;
                    y = j + 1;
                    break;
                }
                // 세로
                if (i > 2 && i < 17 && graph[i - 2][j] == graph[i - 1][j]
                        && graph[i - 1][j] == graph[i][j]
                        && graph[i][j] == graph[i + 1][j] && graph[i + 1][j] == graph[i + 2][j]) {
                    winner = graph[i][j];
                    x = i + 1;
                    y = j + 1;
                    break;
                }

                // 대각선 /
                if (i > 2 && j < 17 && i < 17 && j > 2 && graph[i - 2][j + 2] == graph[i - 1][j + 1]
                        && graph[i - 1][j + 1] == graph[i][j]
                        && graph[i][j] == graph[i + 1][j - 1] && graph[i + 1][j - 1] == graph[i
                        + 2][j - 2]) {
                    winner = graph[i][j];
                    x = i + 1;
                    y = j + 1;
                    break;
                }

                // 대각선 \
                if (i > 2 && j > 2 && j < 17 && i < 17 && graph[i - 2][j - 2] == graph[i - 1][j - 1]
                        && graph[i - 1][j - 1] == graph[i][j]
                        && graph[i][j] == graph[i + 1][j + 1] && graph[i + 1][j + 1] == graph[i
                        + 2][j + 2]) {
                    winner = graph[i][j];
                    x = i + 1;
                    y = j + 1;

                    break;
                }

            }


        }
        System.out.println(winner);
        if (winner != 0) {
            System.out.println(x + " " + y);
        }
    }
}