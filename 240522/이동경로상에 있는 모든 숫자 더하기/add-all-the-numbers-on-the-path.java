import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int startX = n / 2;
        int startY = n / 2;
        int direction = 0;

        int sum = arr[startX][startY];
        for (String string : s.split("")) {
            if (string.equals("L")) {
                direction = (direction + 3) % 4;
            } else if (string.equals("R")) {
                direction = (direction + 1) % 4;
            } else {
                if (direction == 0 && startX > 0) {
                    sum += arr[--startX][startY];
                } else if (direction == 1 && startY < n - 1) {
                    sum += arr[startX][++startY];
                } else if (direction == 2 && startX < n - 1) {
                    sum += arr[++startX][startY];
                } else if (direction == 3 && startY > 0) {
                    sum += arr[startX][--startY];
                }
            }
        }

        System.out.println(sum);
    }

}