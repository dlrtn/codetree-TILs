import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        int[] counterClockwiseDx = {1, -1, -1, 1};
        int[] counterClockwiseDy = {-1, -1, 1, 1};

        int[] clockwiseDx = {-1, 1, 1, -1};
        int[] clockwiseDy = {-1, -1, 1, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int[] m = new int[4];
        for (int i = 0; i < 4; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        int dir = Integer.parseInt(st.nextToken());

        int nowX = c;
        int nowY = r;

        if (dir == 0) { // 반시계 방향
            int temp = map[nowY][nowX];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < m[3 - i]; j++) {
                    map[nowY][nowX] = map[nowY + clockwiseDy[i]][nowX + clockwiseDx[i]];
                    nowX += clockwiseDx[i];
                    nowY += clockwiseDy[i];
                }
            }
            map[nowY + clockwiseDy[1]][nowX + clockwiseDx[1]] = temp;
        } else { // 시계 방향
            int temp = map[nowY][nowX];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < m[i]; j++) {
                    map[nowY][nowX] = map[nowY + counterClockwiseDy[i]][nowX
                            + counterClockwiseDx[i]];
                    nowX += counterClockwiseDx[i];
                    nowY += counterClockwiseDy[i];
                }
            }
            map[nowY + counterClockwiseDy[1]][nowX + counterClockwiseDx[1]] = temp;
        }

        // print the map
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}