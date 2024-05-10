import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n1 - n2 + 1; i++) {
            int count = 0;
            for (int j = 0; j < n2; j++) {
                if (arr1[i + j] == arr2[j]) {
                    count++;
                }
            }
            if (count == n2) {
                System.out.println("Yes");
                exit(0);
            }

        }
        System.out.println("No");
    }

}