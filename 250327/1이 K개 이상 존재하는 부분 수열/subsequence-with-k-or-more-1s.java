import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = Integer.MAX_VALUE;
        
        int oneCount = 0, j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && oneCount < k) {
                if (arr[j] == 1) {
                    oneCount++;
                }
                j++;
            }
            
            if (oneCount >= k) {
                answer = Math.min(answer, j - i);
            }
            
            if (arr[i] == 1) {
                oneCount--;
            }
        }
        
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
