import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n];

        int[][] arr = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        LinkedList<HashSet> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
            HashSet<Integer> set = new HashSet<>();

            set.add(i);
            list.add(set);
        }

        // a1, b1

        for (int i = 0; i < 3 * k; i++) {
            int a = arr[i % 4][0] - 1;
            int b = arr[i % 4][1] - 1;

            swap(array, a, b);

            list.get(array[a] - 1).add(a);
            list.get(array[b] - 1).add(b);
        }

        for (HashSet<Integer> set : list) {
            System.out.println(set.size());
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
