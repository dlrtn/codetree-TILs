import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String instruction = st.nextToken();
            int x;

            switch (instruction) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    treeSet.add(x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    treeSet.remove(x);
                    break;
                case "find":
                    x = Integer.parseInt(st.nextToken());
                    System.out.println(treeSet.contains(x) ? "true" : "false");
                    break;
                case "lower_bound":
                    x = Integer.parseInt(st.nextToken());
                    if (treeSet.ceiling(x) != null) {
                        System.out.println(treeSet.ceiling(x));
                    } else {
                        System.out.println("None");
                    }
                    break;
                case "upper_bound":
                    x = Integer.parseInt(st.nextToken());
                    if (treeSet.higher(x) != null) {
                        System.out.println(treeSet.higher(x));
                    } else {
                        System.out.println("None");
                    }
                    break;
                case "largest":
                    if (treeSet.isEmpty()) {
                        System.out.println("None");
                    } else {
                        System.out.println(treeSet.last());
                    }
                    break;
                case "smallest":
                    if (treeSet.isEmpty()) {
                        System.out.println("None");
                    } else {
                        System.out.println(treeSet.first());
                    }
                    break;
            }
        }
    }
}
