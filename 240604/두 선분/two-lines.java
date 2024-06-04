import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] x = new int[4];
        for (int i = 0; i < 4; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        boolean isAscending = false;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (x[i] >= x[j]) {
                    isAscending = true;
                }
            }
        }

        if (isAscending) {
            System.out.println("intersecting");
        } else {
            System.out.println("nonintersecting");
        }
    }

}