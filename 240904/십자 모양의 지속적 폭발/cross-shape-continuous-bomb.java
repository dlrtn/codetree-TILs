import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static int n, m;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int column = Integer.parseInt(st.nextToken());

            boom(column - 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void boom(int columnIndex) {
        int rowIndex = findExplosionRowIndex(columnIndex);

        if (rowIndex == -1) { // 더이상 터질 폭탄이 해당 열에 남아있지 않음
            return;
        }

        // 폭탄 터짐
        int boomRange = map[rowIndex][columnIndex];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i > rowIndex - boomRange && i < rowIndex + boomRange) && (columnIndex == j) || (j > columnIndex - boomRange && j < columnIndex + boomRange) && (rowIndex == i)) {
                    map[i][j] = 0;
                }
            }
        }

        // 중력 작용
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = n - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    queue.add(map[j][i]);
                }
            }

            while (queue.size() != n) {
                queue.add(0);
            }

            for (int j = n - 1; j >= 0; j--) {
                temp[j][i] = queue.poll();
            }
        }

        map = temp;
    }

    private static int findExplosionRowIndex(int column) {
        for (int i = 0; i < n; i++) {
            if (map[i][column] != 0) {
                return i;
            }
        }

        return -1;
    }
}