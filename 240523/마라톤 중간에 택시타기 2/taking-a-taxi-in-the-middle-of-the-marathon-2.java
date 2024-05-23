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

        int n = Integer.parseInt(st.nextToken());

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes.add(new Node(x, y));
        }

        int minDistance = Integer.MAX_VALUE;

        for (int j = 1; j < n - 1; j++) {
            int distanceSum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (i == j) {
                    distanceSum += Math.abs(nodes.get(i - 1).x - nodes.get(i + 1).x) + Math.abs(
                            nodes.get(i + 1).y - nodes.get(i - 1).y);
                } else if (i == j - 1) {
                    continue;
                } else {
                    distanceSum += Math.abs(nodes.get(i).x - nodes.get(i + 1).x) + Math.abs(
                            nodes.get(i + 1).y - nodes.get(i).y);
                }


            }
            minDistance = Math.min(minDistance, distanceSum);
        }

        System.out.println(minDistance);
    }

    public static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}