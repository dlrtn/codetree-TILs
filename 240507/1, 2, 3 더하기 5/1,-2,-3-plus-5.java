import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static int count = 0;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Node node = new Node(new LinkedList<>());

        backtracking(n, node);
    }

    public static void backtracking(int n, Node node) {
        if (node.sum >= n) {
            if (node.sum == n) {
                count++;
                if (count == k) {
                    node.print();
                }
            }
            return;
        }

        node.sumOne();
        backtracking(n, node);
        node.sub();

        node.sumTwo();
        backtracking(n, node);
        node.sub();

        node.sumThree();
        backtracking(n, node);
        node.sub();
    }

    public static class Node {

        public LinkedList<Integer> list;
        public int sum = 0;

        public Node(LinkedList<Integer> list) {
            this.list = list;
        }

        public void sumOne() {
            sum += 1;
            list.addLast(1);
        }

        public void sumTwo() {
            sum += 2;
            list.addLast(2);
        }

        public void sumThree() {
            sum += 3;
            list.addLast(3);
        }

        public void sub() {
            if (list.getLast() == 1) {
                sum -= 1;
            } else if (list.getLast() == 2) {
                sum -= 2;
            } else {
                sum -= 3;
            }
            list.removeLast();
        }

        public void print() {
            System.out.println(list.stream().collect(StringBuilder::new, (sb, i) -> sb.append(i).append("+"), StringBuilder::append).deleteCharAt(list.size() * 2 - 1));
        }
    }
}