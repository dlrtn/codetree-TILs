import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        LinkedList<Integer> arr = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            LinkedList<Integer> temp = new LinkedList<>();
            for (int j = 0; j < s - 1; j++) {
                temp.add(arr.poll());
            }

            for (int j = 0; j < e - 1; j++) {
                arr.poll();
            }

            while (!arr.isEmpty()) {
                temp.add(arr.poll());
            }

            arr = temp;
        }

        System.out.println(arr.size());
        arr.forEach(System.out::println);

    }
}