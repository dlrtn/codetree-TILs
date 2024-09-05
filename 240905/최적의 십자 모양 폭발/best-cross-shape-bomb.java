import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] temp = boom(i, j, map);
                max = Math.max(countTwins(temp), max);
            }
        }

        System.out.println(max);
    }

    private static int[][] boom(int rowIndex, int columnIndex, int[][] map) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, temp[i], 0, n);
        }

        // 폭탄 터짐
        int boomRange = temp[rowIndex][columnIndex];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i > rowIndex - boomRange && i < rowIndex + boomRange) && (columnIndex == j)
                        || (j > columnIndex - boomRange && j < columnIndex + boomRange) && (rowIndex
                        == i)) {
                    temp[i][j] = 0;
                }
            }
        }

        // 중력 작용
        int[][] temp2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = n - 1; j >= 0; j--) {
                if (temp[j][i] != 0) {
                    queue.add(temp[j][i]);
                }
            }

            while (queue.size() != n) {
                queue.add(0);
            }

            for (int j = n - 1; j >= 0; j--) {
                temp2[j][i] = queue.poll();
            }
        }

        return temp2;
    }

    private static int countTwins(int[][] map) {
        int numberCount = 0;
        for (int i = 0; i < n; i++) {
            int nowNumber = 0;
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (nowNumber != map[j][i]) {
                    if (nowNumber != 0 && count == 2) {
                        numberCount++;
                    }
                    nowNumber = map[j][i];
                    count = 1;
                } else {
                    count++;
                }
            }
            if (nowNumber != 0 && count == 2) {
                numberCount++;
            }
        }

        for (int i = 0; i < n; i++) {
            int nowNumber = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nowNumber != map[i][j]) {
                    if (nowNumber != 0 && count == 2) {
                        numberCount++;
                    }
                    nowNumber = map[i][j];
                    count = 1;
                } else {
                    count++;
                }
            }
            if (nowNumber != 0 && count == 2) {
                numberCount++;
            }
        }

        return numberCount;
    }

}