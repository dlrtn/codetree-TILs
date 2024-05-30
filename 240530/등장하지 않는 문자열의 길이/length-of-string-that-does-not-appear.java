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

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            // i == 문자열의 길이
            boolean isPossible = true;
            for (int j = 0; j < n - i + 1; j++) {
                String temp = s.substring(j, j + i);

                // 중복해서 존재하는 경우
                if (s.lastIndexOf(temp) != s.indexOf(temp)) {
                    isPossible = false;
                    break;
                }

            }

            if (isPossible) {
                min = Math.min(min, i);
            }

        }

        System.out.println(min);
    }
}