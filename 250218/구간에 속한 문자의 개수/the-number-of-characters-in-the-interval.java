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
        int k = Integer.parseInt(st.nextToken());

        char[][] map = new char[n + 1][m + 1];

        int[][] a_cnt = new int[n + 1][m + 1];
        int[][] b_cnt = new int[n + 1][m + 1];
        int[][] c_cnt = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j - 1);


                if (map[i][j] == 'a') {
                    a_cnt[i][j]++;
                } else if (map[i][j] == 'b') {
                    b_cnt[i][j]++;
                } else if (map[i][j] == 'c') {
                    c_cnt[i][j]++;
                }

                a_cnt[i][j] += a_cnt[i - 1][j] + a_cnt[i][j - 1] - a_cnt[i - 1][j - 1];
                b_cnt[i][j] += b_cnt[i - 1][j] + b_cnt[i][j - 1] - b_cnt[i - 1][j - 1];
                c_cnt[i][j] += c_cnt[i - 1][j] + c_cnt[i][j - 1] - c_cnt[i - 1][j - 1];
            }
        }
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int a = a_cnt[x2][y2] - a_cnt[x1][y2] - a_cnt[x2][y1] + a_cnt[x1][y1];
            int b = b_cnt[x2][y2] - b_cnt[x1][y2] - b_cnt[x2][y1] + b_cnt[x1][y1];
            int c = c_cnt[x2][y2] - c_cnt[x1][y2] - c_cnt[x2][y1] + c_cnt[x1][y1];

            System.out.println(a + " " + b + " " + c);
        }

    }
}
