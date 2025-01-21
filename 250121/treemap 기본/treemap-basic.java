import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String instruction = st.nextToken();

            switch (instruction) {
                case "add":
                    int key = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());
                    map.put(key, value);
                    break;
                case "remove":
                    int keyToRemove = Integer.parseInt(st.nextToken());
                    map.remove(keyToRemove);
                    break;
                case "find":
                    int keyToFind = Integer.parseInt(st.nextToken());
                    System.out.println(map.containsKey(keyToFind) ? map.get(keyToFind) : "None");
                    break;
                case "print_list":
                    if (map.isEmpty()) {
                        System.out.println("None");
                    } else {
                        for (int k : map.keySet()) {
                            System.out.print(map.get(k) + " ");
                        }
                        System.out.println();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
