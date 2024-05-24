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

        List<Sign> signs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            char sign = st.nextToken().charAt(0);

            signs.add(new Sign(index, sign));
        }

        signs.sort((o1, o2) -> {
            return o1.index - o2.index;
        });

        int answer = 0;

        for (int j = 1; j < signs.size(); j++) {
            for (int i = 0; i < signs.size() - j; i++) {
                int gCount = 0;
                int hCount = 0;
                for (int k = 0; k <= j; k++) {
                    if (signs.get(i + k).sign == 'G') {
                        gCount++;
                    } else {
                        hCount++;
                    }
                }
                if (gCount == hCount) {
                    answer = Math.max(answer, signs.get(i + j).index - signs.get(i).index);
                }
                if (gCount == 0) {
                    answer = Math.max(answer, signs.get(i + j).index - signs.get(i).index);
                }
                if (hCount == 0) {
                    answer = Math.max(answer, signs.get(i + j).index - signs.get(i).index);
                }
            }
        }

        System.out.println(answer);
    }

    public static class Sign {
        int index;
        char sign;

        public Sign(int index, char sign) {
            this.index = index;
            this.sign = sign;
        }
    }


}