import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        NumberCount numberCount = new NumberCount();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            numberCount.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        for (int i = 0; i <= n - m; i++) {
            NumberCount tempNumberCount = new NumberCount();
            for (int j = 0; j < m; j++) {
                tempNumberCount.add(arr[i + j]);
            }
            if (numberCount.equals(tempNumberCount)) {
                count++;
            }
        }

        System.out.println(count);


    }

    public static class NumberCount {

        public Map<Integer, Integer> map;

        public NumberCount() {
            this.map = new HashMap<>();
        }

        public void add(int num) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }


        public boolean equals(NumberCount numberCount) {
            for (int key : map.keySet()) {
                if (!numberCount.map.containsKey(key)) {
                    return false;
                }
                if (!map.get(key).equals(numberCount.map.get(key))) {
                    return false;
                }
            }
            return true;
        }
    }

}