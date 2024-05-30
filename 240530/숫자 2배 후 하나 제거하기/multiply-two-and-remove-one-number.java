import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    temp.add(arr[j] * 2);
                } else {
                    temp.add(arr[j]);
                }
            }

            for (int j = 0; j < n; j++) {
                List<Integer> temp2 = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                    } else {
                        temp2.add(temp.get(k));
                    }
                }
                int sum = 0;
                for (int k = 0; k < temp2.size() - 1; k++) {
                    sum += Math.abs(temp2.get(k) - temp2.get(k + 1));
                }
                answer = Math.min(answer, sum);
            }
        }

        System.out.println(answer);
    }
}