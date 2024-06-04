import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] x = new int[101][101];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int k = y1; k <= y2; k++) {
                for (int l = x1; l <= x2; l++) {
                    x[k][l]++;
                }
            }
            
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (x[i][j] >= 2) {
                    System.out.println("overlapping");
                    return;
                }
            }
        }
        System.out.println("nonoverlapping");
    }
}