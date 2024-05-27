import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int totalSum = Arrays.stream(arr).sum();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    for (int l = 0; l < 6; l++) {
                        if (i == j || i == k || i == l || j == k || j == l || k == l) {
                            continue;
                        }
                        int firstSum = arr[i] + arr[j];
                        int secondSum = arr[k] + arr[l];
                        int thirdSum = totalSum - firstSum - secondSum;

                        int maxTeam = Math.max(firstSum, Math.max(secondSum, thirdSum));
                        int minTeam = Math.min(firstSum, Math.min(secondSum, thirdSum));

                        min = Math.min(min, maxTeam - minTeam);
                    }
                }
            }
        }

        System.out.println(min);
    }
}