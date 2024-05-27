import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] b = new int[3];
        for (int i = 0; i < 3; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if ((isPossible(i, a[0]) && isPossible(j, a[1]) && isPossible(k, a[2])) || (
                            isPossible(i, b[0]) && isPossible(j, b[1]) && isPossible(k, b[2]))) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    // 비교 숫자
    public static boolean isPossible(int num, int comNum) {
        if (Math.abs(num - comNum) <= 2 || Math.abs((num + 2) % n - comNum) == 0 || Math.abs((comNum + 2) % n - num) == 0 || Math.abs((num + 1) % n - comNum) == 0 || Math.abs((comNum + 1) % n - num) == 0){
            return true;
        }
        return false;
    }


}