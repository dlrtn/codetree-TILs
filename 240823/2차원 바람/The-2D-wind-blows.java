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
        int q = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            // rectangle boundaries clockwise rotation
            rotateBorderClockwise(map, r1, c1, r2, c2);

            // change all numbers
            map = changeBoundary(map, r1, c1, r2, c2);
        }

        // print the map
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateBorderClockwise(int[][] matrix, int top, int left, int bottom,
            int right) {
        if (top >= bottom || left >= right) {
            return; // 영역이 유효하지 않으면 종료
        }

        // 외곽 요소를 임시 배열에 저장
        int[] temp = new int[(right - left) * 2 + (bottom - top) * 2];
        int idx = 0;

        // 상단 행
        for (int i = left; i < right; i++) {
            temp[idx++] = matrix[top][i];
        }
        // 우측 열
        for (int i = top; i < bottom; i++) {
            temp[idx++] = matrix[i][right];
        }
        // 하단 행
        for (int i = right; i > left; i--) {
            temp[idx++] = matrix[bottom][i];
        }
        // 좌측 열
        for (int i = bottom; i > top; i--) {
            temp[idx++] = matrix[i][left];
        }

        // 회전 후 값을 다시 삽입
        idx = 0;

        // 우측 열
        for (int i = left + 1; i <= right; i++) {
            matrix[top][i] = temp[idx++];
        }
        // 하단 행
        for (int i = top + 1; i <= bottom; i++) {
            matrix[i][right] = temp[idx++];
        }
        // 좌측 열
        for (int i = right - 1; i >= left; i--) {
            matrix[bottom][i] = temp[idx++];
        }
        // 상단 행
        for (int i = bottom - 1; i >= top; i--) {
            matrix[i][left] = temp[idx++];
        }
    }

    public static int[][] changeBoundary(int[][] map, int r1, int c1, int r2, int c2) {
        int[] dx = { 0, 1, 0, -1, 0 };
        int[] dy = { 0, 0, 1, 0, -1 };

        int[][] newMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i < r1 || i > r2 || j < c1 || j > c2) {
                    newMap[i][j] = map[i][j];
                } else {
                    int count = 0;
                    int sum = 0;
                    for (int k = 0; k < 5; k++) {
                        if (i + dx[k] < map.length && i + dx[k] >= 0 && j + dy[k] < map[0].length
                                && j + dy[k] >= 0) {
                            count++;
                            sum += map[i + dx[k]][j + dy[k]];
                        }
                    }

                    newMap[i][j] = sum / count;
                }
            }
        }

        return newMap;
    }
}