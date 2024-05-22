import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int num = 1;

        int[][] answer = new int[n][n];

        int dir = -1;
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, -1, -0, 1};

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n - 1; i++) {
            if (i != n - 1 && i != 1) {
                queue.add(i);
                queue.add(i);
            } else {
                queue.add(i);
                queue.add(i);
                queue.add(i);
            }
        }

        int x = n / 2;
        int y = n / 2;

        int count = queue.poll();
        for (int i = 0; i < n * n; i++) {
            answer[x][y] = num++;

            count--;
            if (count == 0) {
                dir = (dir + 1) % 4;
                if (!queue.isEmpty()) {
                    count = queue.poll();
                } else {
                    continue;
                }
            }

            x += dx[dir];
            y += dy[dir];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

}