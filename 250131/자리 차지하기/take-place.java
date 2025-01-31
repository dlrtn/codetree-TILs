import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n, m;
    public static int[] arr = new int[MAX_N];
    
    public static TreeSet<Integer> seats = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        // 1번부터 m번까지 전부 비어져 있으므로
        // 빈 위치를 treeset으로 관리합니다.
        for(int i = 1; i <= m; i++)
            seats.add(i);

        // 답을 구해줍니다.
        int ans = 0;

        // 순서대로 앉혀봅니다.
        // 최선의 자리 선택은
        // ai보다 같거나 작은 최대 위치에 자리배치를 하는 것입니다.
        for(int i = 0; i < n; i++) {
            // ai보다 같거나 작은 최댓값을 찾습니다.
            // 존재하는 경우
            // 해당 위치에 사람을 앉혀줍니다.
            if(seats.floor(arr[i]) != null) {
                int num = seats.floor(arr[i]);
                seats.remove(num);
                
                // 답을 갱신해줍니다.
                ans++;
            }
            else
                break;
        }

        System.out.print(ans);
    }
}