import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] map = new int[4][4];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String dir = br.readLine();

        if (dir.equals("L")) { // 왼쪽으로 이동
            // 오른쪽으로 가면서 현재 위치의 숫자 0인 경우, 다음 자리의 숫자를 가져와서 현재 위치에 넣어준다.

            for (int i = 0; i < 4; i++) {
                LinkedList<Integer> queue = new LinkedList<>();

                for (int j = 0; j < 4; j++) {
                    if (map[i][j] != 0) {
                        queue.add(map[i][j]);
                    }
                }

                Queue<Integer> temp = new LinkedList<>();
                while (!queue.isEmpty()) {
                    int nowNumber = queue.pollFirst();

                    if (!queue.isEmpty() && nowNumber == queue.peekFirst()) {
                        queue.pollFirst();
                        temp.add(nowNumber * 2);
                    } else {
                        temp.add(nowNumber);
                    }
                }

                while (temp.size() != 4) {
                    temp.add(0);
                }

                for (int j = 0; j < 4; j++) {
                    map[i][j] = temp.poll();
                }
            }

        } else if (dir.equals("R")) { // 오른쪽으로 이동
            // 왼쪽으로 가면서 현재 위치의 숫자 0인 경우, 다음 자리의 숫자를 가져와서 현재 위치에 넣어준다.
            LinkedList<Integer> queue = new LinkedList<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 3; j >= 0; j--) {
                    if (map[i][j] != 0) {
                        queue.add(map[i][j]);
                    }
                }

                LinkedList<Integer> temp = new LinkedList<>();
                while (!queue.isEmpty()) {
                    int nowNumber = queue.pollFirst();

                    if (!queue.isEmpty() && nowNumber == queue.peekFirst()) {
                        queue.pollFirst();
                        temp.addFirst(nowNumber * 2);
                    } else {
                        temp.addFirst(nowNumber);
                    }
                }

                while (temp.size() != 4) {
                    temp.addFirst(0);
                }

                for (int j = 0; j < 4; j++) {
                    map[i][j] = temp.poll();
                }
            }


        } else if (dir.equals("U")) { // 위로 이동
            // 아래로 가면서 현재 위치의 숫자 0인 경우, 다음 자리의 숫자를 가져와서 현재 위치에 넣어준다.
            LinkedList<Integer> queue = new LinkedList<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (map[j][i] != 0) {
                        queue.add(map[j][i]);
                    }
                }

                Queue<Integer> temp = new LinkedList<>();
                while (!queue.isEmpty()) {
                    int nowNumber = queue.pollFirst();

                    if (!queue.isEmpty() && nowNumber == queue.peekFirst()) {
                        queue.pollFirst();
                        temp.add(nowNumber * 2);
                    } else {
                        temp.add(nowNumber);
                    }
                }

                while (temp.size() != 4) {
                    temp.add(0);
                }

                for (int j = 0; j < 4; j++) {
                    map[j][i] = temp.poll();
                }
            }
        } else { // 아래로 이동
            // 위로 가면서 현재 위치의 숫자 0인 경우, 다음 자리의 숫자를 가져와서 현재 위치에 넣어준다.
            LinkedList<Integer> queue = new LinkedList<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 3; j >= 0; j--) {
                    if (map[j][i] != 0) {
                        queue.add(map[j][i]);
                    }
                }

                Queue<Integer> temp = new LinkedList<>();
                while (!queue.isEmpty()) {
                    int nowNumber = queue.pollFirst();

                    if (!queue.isEmpty() && nowNumber == queue.peekFirst()) {
                        queue.pollFirst();
                        temp.add(nowNumber * 2);
                    } else {
                        temp.add(nowNumber);
                    }
                }

                while (temp.size() != 4) {
                    temp.add(0);
                }

                for (int j = 3; j >= 0; j--) {
                    map[j][i] = temp.poll();
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}