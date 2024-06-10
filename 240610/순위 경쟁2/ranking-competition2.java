import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] scores = new int[2];
        Winner winner = Winner.NONE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String studentA = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            if (studentA.equals("A")) {
                scores[0] += score;
            } else {
                scores[1] += score;
            }

            if (scores[0] > scores[1]) {
                if (winner != Winner.A) {
                    count++;
                    winner = Winner.A;
                }
            } else if (scores[0] < scores[1]) {
                if (winner != Winner.B) {
                    count++;
                    winner = Winner.B;
                }
            } else {
                if (winner != Winner.AB) {
                    count++;
                    winner = Winner.AB;
                }
            }

        }
        System.out.println(count);
    }

    public enum Winner {
        A, B, AB, NONE;
    }
}