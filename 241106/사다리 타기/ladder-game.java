import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] result;
    static int n;
    static int m;
    static boolean[] used;
    static int answer = Integer.MAX_VALUE;
    static int[] firstResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[n];
        used = new boolean[m];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }

        LinkedList<Sadari> sadari = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            sadari.add(new Sadari(x, height));
        }

        used = new boolean[m];
        for (int i = 0; i < m; i++) {
            used[i] = true;
        }
        firstResult = sadari(sadari);
        for (int i = 0; i < m; i++) {
            used[i] = false;
        }

        backtracking(sadari, 0);

        System.out.println(answer);
    }

    public static void backtracking(LinkedList<Sadari> sadari, int depth) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (used[i]) {
                count++;
            }
        }

        int answerCount = 0;
        int[] temp = sadari(sadari);
        for (int i = 0; i < n; i++) {
            if (temp[i] == firstResult[i]) {
                answerCount++;
            }
        }
        if (answerCount == n) {
            answer = Math.min(answer, count);
        }

        for (int i = depth; i < m; i++) {
            if (!used[i]) {
                used[i] = true;
            }
            backtracking(sadari, depth + 1);
            used[i] = false;
        }
    }

    public static int[] sadari(LinkedList<Sadari> sadaris) {
        int[] temp = new int[n];

        sadaris.sort((o1, o2) -> {
            if (o1.height == o2.height) {
                return o1.x - o2.x;
            }
            return o1.height - o2.height;
        });

        int lastHeight = sadaris.getLast().height;
        for (int i = 0; i < n; i++) {
            int nowX = i + 1;

            for (int j = 1; j <= lastHeight; j++) {
                for (int k = 0; k < m; k++) {
                    Sadari now = sadaris.get(k);
                    if (used[k] && (nowX) == now.x && j == now.height) {
                        nowX++;
                        break;
                    } else if (used[k] && (nowX - 1) == now.x && j == now.height) {
                        nowX--;
                        break;
                    }
                }
            }

            temp[nowX - 1] = i + 1;
        }

        return temp;
    }

    public static class Sadari {
        int x;
        int height;

        public Sadari(int x, int height) {
            this.x = x;
            this.height = height;
        }
    }
}