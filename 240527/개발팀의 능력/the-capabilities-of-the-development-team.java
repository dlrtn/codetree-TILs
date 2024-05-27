import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int totalSum = Arrays.stream(arr).sum();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (i == j || i == k || i == l || j == k || j == l || k == l) {
                            continue;
                        }
                        int firstSum = arr[i] + arr[j];
                        int secondSum = arr[k] + arr[l];
                        int thirdSum = totalSum - firstSum - secondSum;

                        if (firstSum == secondSum || firstSum == thirdSum || secondSum == thirdSum) {
                            continue;
                        }

                        int maxTeam = Math.max(firstSum, Math.max(secondSum, thirdSum));
                        int minTeam = Math.min(firstSum, Math.min(secondSum, thirdSum));

                        min = Math.min(min, maxTeam - minTeam);
                    }
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }
}