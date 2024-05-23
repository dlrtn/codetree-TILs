import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
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

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 2; j++) {
                int tempCount = 0;
                for (int k = 0; k < 3; k++) {
                    if (map[i][j + k] == 1) {
                        tempCount++;
                    }
                }
                for (int k = i; k < n; k++) {
                    for (int l = j; l < n - 2; l++) {
                        if (i == k && l < j + 2) {
                            continue;
                        }
                        int tempCount2 = 0;
                        for (int m = 0; m < 3; m++) {
                            if (map[k][l + m] == 1) {
                                tempCount2++;
                            }
                        }
                        max = Math.max(max, tempCount + tempCount2);
                    }
                }
            }
        }

        System.out.println(max);
    }
}