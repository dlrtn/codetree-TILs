import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                int minDistance = Integer.MAX_VALUE;
                String str = s.substring(0, i) + "1" + s.substring(i + 1);

                // 처음부터 끝까지 떨어진 사람들의 거리를 구한다.
                int distance = 0;
                for (int j = 0; j < n; j++) {
                    // distance == 0인 경우는 붙어 있다.
                    if (str.charAt(j) == '1') {
                        if (j == 0) {
                            continue;
                        }
                        minDistance = Math.min(minDistance, distance);
                        distance = 0;
                    } else {
                        distance++;
                    }
                }

                answer = Math.max(answer, minDistance);
            }


        }

        System.out.println(answer + 1);
    }
}