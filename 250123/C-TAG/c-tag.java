import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] arrA = new String[n][m];
        String[][] arrB = new String[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String[] strings = st.nextToken().split("");

            for (int j = 0; j < m; j++) {
                arrA[i][j] = strings[j];
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String[] strings = st.nextToken().split("");

            for (int j = 0; j < m; j++) {
                arrB[i][j] = strings[j];
            }
        }

        int result = 0;

        HashSet<String> hashSetA = new HashSet<>();
        HashSet<String> hashSetB = new HashSet<>();
        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    for (int l = 0; l < n; l++) {
                        hashSetA.add(arrA[l][i] + arrA[l][j] + arrA[l][k]);
                        hashSetB.add(arrB[l][i] + arrB[l][j] + arrB[l][k]);
                    }

                    boolean isContains = false;
                    for (String string: hashSetA) {
                        if (hashSetB.contains(string)) {
                            isContains = true;
                        }
                    }

                    if (!isContains) {
                        result++;
                    }

                    hashSetA.clear();
                    hashSetB.clear();
                }
            }
        }

        System.out.println(result);
    }
}
