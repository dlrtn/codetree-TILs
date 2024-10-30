import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    private static final int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // m 번에 걸쳐서 이동한다.
        // 이때 조건은 다음과 같다.
        // 각 위치에서 여덟 방향으로 인접한 칸 중, 가장 큰 값이 적혀있는 숫자가 있는 곳으로 이동한다.

        LinkedList<LinkedList<Stack>> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new LinkedList<>());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list.get(i).add(new Stack<Integer>());
                list.get(i).get(j).push(Integer.parseInt(st.nextToken()));
            }
        }

        int[] movingNumbers = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            movingNumbers[i] = Integer.parseInt(st.nextToken());
        }

        int x = -1;
        int y = -1;
        for (int i = 0; i < m; i++) {
            // find moving number's index
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Stack<Integer> nowStack = list.get(j).get(k);

                    for (int l = 0; l < nowStack.size(); l++) {
                        if (nowStack.get(l) == movingNumbers[i]) {
                            x = j;
                            y = k;
                        }
                    }
                }
            }

            int maxNumber = 0;
            int maxNumberX = -1;
            int maxNumberY = -1;
            for (int j = 0; j < 8; j++) {
                int nextX = x + dx[j];
                int nextY = y + dy[j];
                if ((nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) || list.get(nextX).get(nextY).isEmpty()) {
                    continue;
                }

                if (maxNumber < (int) list.get(nextX).get(nextY).get(0)) {
                    maxNumber = (int) list.get(nextX).get(nextY).get(0);
                    maxNumberX = nextX;
                    maxNumberY = nextY;
                }
            }

            if (maxNumberX == -1 && maxNumberY == -1) {
                continue;
            }

            int stackIndex = list.get(x).get(y).indexOf(movingNumbers[i]);
            int stackSize = list.get(x).get(y).size();
            for (int j = stackIndex; j < stackSize; j++) {
                list.get(maxNumberX).get(maxNumberY).push(list.get(x).get(y).get(stackIndex));
                list.get(x).get(y).remove(stackIndex);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (list.get(i).get(j).isEmpty()) {
                    System.out.print("None");
                } else {
                    while (!list.get(i).get(j).isEmpty()) {
                        System.out.print(list.get(i).get(j).pop() + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}