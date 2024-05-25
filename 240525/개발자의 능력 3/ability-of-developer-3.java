import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] abilities = new int[6];

        for (int i = 0; i < 6; i++) {
            abilities[i] = Integer.parseInt(st.nextToken());
        }

        int total = Arrays.stream(abilities).sum();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k < 6; k++) {
                    int tempSum = abilities[i] + abilities[j] + abilities[k];
                    int temp = total - tempSum;

                    min = Math.min(min, Math.abs(tempSum - temp));
                }
            }
        }

        System.out.println(min);
    }
}