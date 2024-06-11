import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 각 묶음이 최소가 되게 묶어라..?
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        count += evenCount * 2;
        oddCount -= evenCount;

        boolean isEven;
        if (evenCount % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }

        while (oddCount > 0) {
            if (isEven) {
                if (oddCount >= 2) {
                    count++;
                    oddCount -= 2;
                    isEven = false;
                } else {
                    count--;
                    break;
                }
            } else {
                count++;
                oddCount--;
                isEven = true;
            }
        }

        System.out.println(count);


    }
}