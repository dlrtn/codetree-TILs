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

        int[] scores = new int[3];
        Winner winner = Winner.ABC;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String studentA = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            if (studentA.equals("A")) {
                scores[0] += score;
            } else if (studentA.equals("B")) {
                scores[1] += score;
            } else {
                scores[2] += score;
            }

            // A가 제일 큰 경우,,
            if (scores[0] > scores[1] && scores[0] > scores[2]) {
                if (winner != Winner.A) {
                    count++;
                }
                winner = Winner.A;
            } else if (scores[1] > scores[0] && scores[1] > scores[2]) {
                if (winner != Winner.B) {
                    count++;
                }
                winner = Winner.B;
            } else if (scores[2] > scores[0] && scores[2] > scores[1]) {
                if (winner != Winner.C) {
                    count++;
                }
                winner = Winner.C;
            } else if (scores[0] == scores[1] && scores[0] > scores[2]) {
                if (winner != Winner.AB) {
                    count++;
                }
                winner = Winner.AB;
            } else if (scores[0] == scores[2] && scores[0] > scores[1]) {
                if (winner != Winner.AC) {
                    count++;
                }
                winner = Winner.AC;
            } else if (scores[1] == scores[2] && scores[1] > scores[0]) {
                if (winner != Winner.BC) {
                    count++;
                }
                winner = Winner.BC;
            } else if (scores[0] == scores[1] && scores[0] == scores[2]) {
                if (winner != Winner.ABC) {
                    count++;
                }
                winner = Winner.ABC;
            }
        }
        System.out.println(count);
    }

    public enum Winner {
        A, B, C, AB, BC, AC, ABC;
    }
}