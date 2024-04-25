import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Set<String> arrayList = bfs(n);

        System.out.println(arrayList.size());
    }

    public static class Node {

        int aCount;
        int bCount;
        String str;

        public Node(int aCount, int bCount, String str) {
            this.aCount = aCount;
            this.bCount = bCount;
            this.str = str;
        }


    }

    public static Set<String> bfs(int n) {
        Set<String> answers = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0, "a"));

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();

            if (nowNode.aCount == nowNode.bCount && nowNode.bCount == n) {
                answers.add(nowNode.str);
                continue;
            }

            if (nowNode.bCount < n && nowNode.aCount > nowNode.bCount) {
                queue.add(new Node(nowNode.aCount, nowNode.bCount + 1, nowNode.str + 'b'));
            }

            if (nowNode.aCount < n) {
                queue.add(new Node(nowNode.aCount + 1, nowNode.bCount, nowNode.str + 'a'));
            }
        }

        return answers;
    }
}