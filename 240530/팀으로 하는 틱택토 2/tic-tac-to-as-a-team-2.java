import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            String[] temp = st.nextToken().split("");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = temp[j].charAt(0) - '0';
            }
        }

        int count = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                boolean isWin = false;
                // 1 2 3
                if ((arr[0][0] == i || arr[0][0] == j) && ((arr[0][1] == i) || (arr[0][1] == j))
                        && ((arr[0][2] == i) || (arr[0][2] == j))
                        && !(arr[0][0] == i && arr[0][1] == i && arr[0][2] == i) && !(arr[0][0] == j
                        && arr[0][1] == j && arr[0][2] == j)) {
                    isWin = true;
                }

                // 4 5 6
                if ((arr[1][0] == i || arr[1][0] == j) && ((arr[1][1] == i) || (arr[1][1] == j))
                        && ((arr[1][2] == i) || (arr[1][2] == j))
                        && !(arr[1][0] == i && arr[1][1] == i && arr[1][2] == i) && !(arr[1][0] == j
                        && arr[1][1] == j && arr[1][2] == j)) {
                    isWin = true;
                }

                // 7 8 9
                if ((arr[2][0] == i || arr[2][0] == j) && ((arr[2][1] == i) || (arr[2][1] == j))
                        && ((arr[2][2] == i) || (arr[2][2] == j))
                        && !(arr[2][0] == i && arr[2][1] == i && arr[2][2] == i) && !(arr[2][0] == j
                        && arr[2][1] == j && arr[2][2] == j)) {
                    isWin = true;
                }

                // 1 4 7
                if ((arr[0][0] == i || arr[0][0] == j) && ((arr[1][0] == i) || (arr[1][0] == j))
                        && ((arr[2][0] == i) || (arr[2][0] == j))
                        && !(arr[0][0] == i && arr[1][0] == i && arr[2][0] == i) && !(arr[0][0] == j
                        && arr[1][0] == j && arr[2][0] == j)) {
                    isWin = true;
                }

                // 2 5 8
                if ((arr[0][1] == i || arr[0][1] == j) && ((arr[1][1] == i) || (arr[1][1] == j))
                        && ((arr[2][1] == i) || (arr[2][1] == j))
                        && !(arr[0][1] == i && arr[1][1] == i && arr[2][1] == i) && !(arr[0][1] == j
                        && arr[1][1] == j && arr[2][1] == j)) {
                    isWin = true;
                }

                // 3 6 9
                if ((arr[0][2] == i || arr[0][2] == j) && ((arr[1][2] == i) || (arr[1][2] == j))
                        && ((arr[2][2] == i) || (arr[2][2] == j))
                        && !(arr[0][2] == i && arr[1][2] == i && arr[2][2] == i) && !(arr[0][2] == j
                        && arr[1][2] == j && arr[2][2] == j)) {
                    isWin = true;
                }

                // 1 5 9
                if ((arr[0][0] == i || arr[0][0] == j) && ((arr[1][1] == i) || (arr[1][1] == j))
                        && ((arr[2][2] == i) || (arr[2][2] == j))
                        && !(arr[0][0] == i && arr[1][1] == i && arr[2][2] == i) && !(arr[0][0] == j
                        && arr[1][1] == j && arr[2][2] == j)) {
                    isWin = true;
                }

                // 3 5 7
                if ((arr[0][2] == i || arr[0][2] == j) && ((arr[1][1] == i) || (arr[1][1] == j))
                        && ((arr[2][0] == i) || (arr[2][0] == j))
                        && !(arr[0][2] == i && arr[1][1] == i && arr[2][0] == i) && !(arr[0][2] == j
                        && arr[1][1] == j && arr[2][0] == j)) {
                    isWin = true;
                }

                if (isWin) {
                    count++;
                }
            }

        }

        System.out.println(count);
    }
}