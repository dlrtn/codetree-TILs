import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int rowIndex = r - 1;
        int columnIndex = c - 1;

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        LinkedList<Integer> visitPath = new LinkedList<>();
        visitPath.add(arr[rowIndex][columnIndex]);

        while (isMovable(arr, rowIndex, columnIndex)) {
            int nowNumber = arr[rowIndex][columnIndex];
            for (int i = 0; i < 4; i++) {
                if (rowIndex + dy[i] < 0 || rowIndex + dy[i] >= arr.length || columnIndex + dx[i] < 0
                        || columnIndex + dx[i] >= arr.length) {
                    continue;
                }

                if (nowNumber < arr[rowIndex + dy[i]][columnIndex + dx[i]]) {
                    visitPath.add(arr[rowIndex + dy[i]][columnIndex + dx[i]]);
                    rowIndex += dy[i];
                    columnIndex += dx[i];
                    break;
                }
            }
        }

        visitPath.forEach(value -> System.out.print(value + " "));
    }

    public static boolean isMovable(int[][] arr, int rowIndex, int columnIndex) {
        int nowNumber = arr[rowIndex][columnIndex];
        for (int i = 0; i < 4; i++) {
            if (rowIndex + dy[i] < 0 || rowIndex + dy[i] >= arr.length || columnIndex + dx[i] < 0
                    || columnIndex + dx[i] >= arr.length) {
                continue;
            }
            if (nowNumber < arr[rowIndex + dy[i]][columnIndex + dx[i]]) {
                return true;
            }
        }
        return false;
    }
}