import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        String[] opponents = new String[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            opponents[i] = st.nextToken();
        }

        int[] scissors = new int[n];
        int[] rock = new int[n];
        int[] paper = new int[n];

        for (int i = 0; i < n; i++) {
            scissors[i] = isWin(opponents[i], "S") ? 1 : 0;
            rock[i] = isWin(opponents[i], "R") ? 1 : 0;
            paper[i] = isWin(opponents[i], "P") ? 1 : 0;
        }

        int[] lScissors = new int[n];
        int[] lRock = new int[n];
        int[] lPaper = new int[n];
        int[] rScissors = new int[n];
        int[] rRock = new int[n];
        int[] rPaper = new int[n];

        lScissors[0] = scissors[0];
        lRock[0] = rock[0];
        lPaper[0] = paper[0];
        rScissors[n - 1] = scissors[n - 1];
        rRock[n - 1] = rock[n - 1];
        rPaper[n - 1] = paper[n - 1];

        for (int i = 1; i < n; i++) {
            lScissors[i] = lScissors[i - 1] + scissors[i];
            lRock[i] = lRock[i - 1] + rock[i];
            lPaper[i] = lPaper[i - 1] + paper[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            rScissors[i] = rScissors[i + 1] + scissors[i];
            rRock[i] = rRock[i + 1] + rock[i];
            rPaper[i] = rPaper[i + 1] + paper[i];
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            int s = 0;
            int r = 0;
            int p = 0;

            if (i == 0) {
                s += rScissors[n - 1];
                r += rRock[n - 1];
                p += rPaper[n - 1];
            } else if (i == n - 1) {
                s += lScissors[i];
                r += lRock[i];
                p += lPaper[i];
            } else {
                s += lScissors[i - 1] + Math.max(rRock[i + 1], rPaper[i + 1]);
                r += lRock[i - 1] + Math.max(rScissors[i + 1], rPaper[i + 1]);
                p += lPaper[i - 1] + Math.max(rScissors[i + 1], rRock[i + 1]);
            }

            max = Math.max(max, Math.max(s, Math.max(r, p)));
        }

        System.out.println(max);
    }

    public static boolean isWin(String opponent, String me) {
        switch (opponent) {
            case "R":
                return !me.equals("S");
            case "S":
                return !me.equals("P");
            case "P":
                return !me.equals("R");
            default:
                return false;
        }
    }
}
