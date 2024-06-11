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

        int count = 0;
        for(int i = 0; i < n; i++) {
            boolean flag = false;
            for(int j = i; j < n - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    flag = true;
                }
            }
            if(flag) count++;
        }

        System.out.println(count);


    }
}