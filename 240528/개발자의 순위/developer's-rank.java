import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[k][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Winner> winners = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            List<Winner> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    if (i == 0) {
                        winners.add(new Winner(arr[i][j], arr[i][l]));
                    } else {
                        for (Winner winner : winners) {
                            if (winner.loser == arr[i][j] && winner.winner == arr[i][l]) {
                                temp.add(winner);
                            }
                        }
                    }
                }
            }

            if (i == 0) {
                continue;
            }
            temp.forEach(winners::remove);

        
//            winners.forEach(winner -> System.out.println(winner.winner + " " + winner.loser));
//            System.out.println();
        }

        System.out.println(winners.size());
    }

    public static class Winner {

        public int winner;
        public int loser;

        public Winner(int winner, int loser) {
            this.winner = winner;
            this.loser = loser;
        }
    }
}