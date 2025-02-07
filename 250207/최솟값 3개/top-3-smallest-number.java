import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            list.add(num);

            if (list.size() >= 3) {
                list.sort(Comparator.naturalOrder());

                int mul = 1;
                for (int j = 0; j < 3; j++) {
                    mul *= list.get(j);
                }

                System.out.println(mul);
            } else {
                System.out.println(-1);
            }
        }
    }
}
