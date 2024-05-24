import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] nodes = new char[10000];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            char alphabet = st.nextToken().charAt(0);

            nodes[index] = alphabet;
        }

        int answer = 0;
        for (int i = 0; i < 10000 - k; i++) {
            int sum = 0;
            for (int j = 0; j <= k; j++) {
                if (nodes[i + j] == 'G') {
                    sum += 1;
                }

                if (nodes[i + j] == 'H') {
                    sum += 2;
                }
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

    public static class Node {
        int index;
        String alphabet;

        public Node(int index, String alphabet) {
            this.index = index;
            this.alphabet = alphabet;
        }
    }
}