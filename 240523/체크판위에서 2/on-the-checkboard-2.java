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

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[][] map = new String[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = st.nextToken();
            }
        }

        Node startNode = new Node(0, 0, map[0][0]);
        Node endNode = new Node(r - 1, c - 1, map[r - 1][c - 1]);

        int count = 0;

        List<Node> nodes = new ArrayList<>();

        // 첫 번째 점프 가능성 확인
        for (int i = 1; i < r - 2; i++) {
            for (int j = 1; j < c - 2; j++) {
                if (!map[i][j].equals(startNode.value)) {
                    nodes.add(new Node(i, j, map[i][j]));
                }
            }
        }

        List<Node> nodes2 = new ArrayList<>();
        // 두 번째 점프 가능성 확인
        for (Node node : nodes) {
            for (int i = node.x + 1; i < r - 1; i++) {
                for (int j = node.y + 1; j < c - 1; j++) {
                    if (!map[i][j].equals(node.value)) {
                        nodes2.add(new Node(i, j, map[i][j]));
                    }
                }
            }
        }

        // 세 번째 점프 가능성 확인
        for (Node node : nodes2) {
            if (!endNode.value.equals(node.value)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static class Node {

        int x;
        int y;
        String value;

        public Node(int x, int y, String value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }


}