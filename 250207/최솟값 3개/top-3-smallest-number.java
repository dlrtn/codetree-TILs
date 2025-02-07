import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> list = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            list.add(num);

            if (list.size() >= 3) {
                LinkedList<Integer> temp = new LinkedList<>();

                long mul = 1;
                for (int j = 0; j < 3; j++) {
                    int val = list.poll();
                    mul *= val;
                    temp.add(val);
                }

                for (int j = 0; j < 3; j++) {
                    list.add(temp.poll());
                }

                System.out.println(mul);
            } else {
                System.out.println(-1);
            }
        }
    }
}
