import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String instruction = st.nextToken();
            int number = 0;
            switch (instruction) {
                case "push_back":
                    number = Integer.parseInt(st.nextToken());
                    list.add(number);
                    break;
                case "pop_back":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        list.remove(list.size() - 1);
                    }
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "get":
                    number = Integer.parseInt(st.nextToken());
                    System.out.println(list.get(number - 1));
                    break;
            }
        }
    }
}