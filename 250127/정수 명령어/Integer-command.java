import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String instruction = st.nextToken();
                int x = Integer.parseInt(st.nextToken());

                switch (instruction) {
                    case "I":
                        treeSet.add(x);
                        break;
                    case "D":
                        if (treeSet.isEmpty()) {
                            continue;
                        } else if (x == -1) {
                            if (!treeSet.isEmpty()) {
                                treeSet.remove(treeSet.first());
                            }
                        } else {
                            if (!treeSet.isEmpty()) {
                                treeSet.remove(treeSet.last());
                            }
                        }
                }
            }

            if (treeSet.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(treeSet.last() + " " + treeSet.first());
            }
        }

    }
}
