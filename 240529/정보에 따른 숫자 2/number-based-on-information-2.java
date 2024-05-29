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

        int t = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> sArr = new ArrayList<>();
        List<Integer> nArr = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            if (s.equals("S")) {
                sArr.add(n);
            } else {
                nArr.add(n);
            }
        }

        int answer = 0;
        for (int i = a; i <= b; i++) {
            int minD1 = Integer.MAX_VALUE;
            for (Integer s : sArr) {
                minD1 = Math.min(minD1, Math.abs(s - i));
            }

            int minD2 = Integer.MAX_VALUE;
            for (Integer n : nArr) {
                minD2 = Math.min(minD2, Math.abs(n - i));
            }


            if (minD1 <= minD2) {
                answer++;
            }

        }

        System.out.println(answer);
    }
}