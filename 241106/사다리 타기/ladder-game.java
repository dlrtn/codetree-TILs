import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static boolean[] used;
    static int answer = Integer.MAX_VALUE;
    static int[] firstResult;
    static int lastHeight;
    static int allCount = 0;
    static LinkedList<Integer> useList = new LinkedList<>();
    static LinkedList<Ladder> ladders = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            ladders.add(new Ladder(x, height));
            useList.add(i);
        }
        ladders.sort((o1, o2) -> {
            if (o1.height == o2.height) {
                return o1.x - o2.x;
            }
            return o1.height - o2.height;
        });
        lastHeight = ladders.getLast().height;

        firstResult = sadari();

        useList.clear();
        backtracking(0);

        System.out.println(answer);
    }

    public static void backtracking(int depth) {
        int answerCount = 0;
        int[] temp = sadari();
        for (int i = 0; i < n; i++) {
            if (temp[i] == firstResult[i]) {
                answerCount++;
            }
        }
        if (answerCount == n) {
            answer = Math.min(answer, useList.size());
        }

        for (int i = depth; i < m; i++) {
            if (useList.contains(i)) {
                continue;
            }
            useList.add(i);
            backtracking(i + 1);
            useList.removeLast();
        }
    }

    public static int[] sadari() {
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            int nowX = i + 1;

            for (int j = 1; j <= lastHeight; j++) {
                for (int k = 0; k < useList.size(); k++) {
                    Ladder now = ladders.get(useList.get(k));
                    if (nowX == now.x && j == now.height) {
                        nowX++;
                        break;
                    } else if ((nowX - 1) == now.x && j == now.height) {
                        nowX--;
                        break;
                    }
                }
            }

            temp[nowX - 1] = i + 1;
        }

        return temp;
    }

    public static class Ladder {
        int x;
        int height;

        public Ladder(int x, int height) {
            this.x = x;
            this.height = height;
        }
    }
}