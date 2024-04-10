import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];

        int x = n - 1;
        int y = n - 1;
        int[] dx = {0, 0, -1};
        int[] dy = {1, -1, 0};
        int size = 0;
        int count = 1;
        arr[y][x] = 1;

        for (int i = 0; i < n * 2 - 1; i++) {
            int nowDx = 0;
            int nowDy = 0;
            switch (i % 2) {
                case 0: // 위로
                    if (i % 4 == 0) {
                        nowDx = dx[1];
                        nowDy = dy[1];
                    } else {
                        nowDx = dx[0];
                        nowDy = dy[0];
                    }
                    size = n - 1;
                    break;
                case 1: // 왼쪽으로
                    nowDx = dx[2];
                    nowDy = dy[2];
                    size = 1;
                    break;  
            }
            for (int j = 0; j < size; j++) {
                y += nowDy;
                x += nowDx;
                arr[y][x] = ++count;
            }
        }
        for (int i = 0; i < n; i++) {            
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}