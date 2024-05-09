import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int num = 0;
        for (int i = Integer.toString(n).length() - 1; i >= 0; i--) {
            num += Math.pow(a, i) * Integer.parseInt(String.valueOf(Integer.toString(n).charAt(i)));
        }

        StringBuffer sb = new StringBuffer();
        int i = 30;
        boolean isZero = true;
        while (num != 0) {
            int now = (int) (num / Math.pow(b, i));

            if (now != 0) {
                isZero = false;
                sb.append(now);
            }
            if (now == 0 && !isZero) {
                sb.append(now);
            }
            num %= Math.pow(b, i--);
        }

        if (i != -1) {
            sb.append(0);
        }

        System.out.println(sb);
    }

}