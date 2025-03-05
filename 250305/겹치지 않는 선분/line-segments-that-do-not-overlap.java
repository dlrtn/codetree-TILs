import java.util.Scanner;
import java.util.Arrays;

class Segment implements Comparable<Segment> {
    int x1, x2;

    public Segment(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Segment s) {
        return this.x1 - s.x1;          // x1 기준 오름차순 정렬
    }
}

public class Main {    
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    
    public static Segment[] segments = new Segment[MAX_N];
    public static int[] L = new int[MAX_N];
    public static int[] R = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Segment(x1, x2);
        }

        // x1 기준으로 정렬합니다.
        Arrays.sort(segments, 0, n);

        // L 배열을 채워줍니다.
        // L[i] = 0번부터 i번까지 선분 중
        //        최대 x2값
        L[0] = segments[0].x2;
        for(int i = 1; i < n; i++)
            L[i] = Math.max(L[i - 1], segments[i].x2);
        
        // R 배열을 채워줍니다.
        // R[i] = i번부터 n - 1번까지 선분 중
        //        최소 x2값
        R[n - 1] = segments[n - 1].x2;
        for(int i = n - 2; i >= 0; i--)
            R[i] = Math.min(R[i + 1], segments[i].x2);
        
        // 각 선분 i에 대해
        // 왼쪽에서 가장 멀리 뻗은 L[i - 1] 값과
        // 오른쪽에서 가장 멀리 뻗은 R[i + 1] 값 모두와 겹치지 않는 경우에만
        // 답을 갱신해줍니다.
        int ans = 0;
        for(int i = 0; i < n; i++) {
            // 왼쪽 선분과 겹치면 패스합니다.
            if(i > 0 && L[i - 1] >= segments[i].x2)
                continue;
            // 오른쪽 선분과 겹치면 패스합니다.
            if(i < n - 1 && R[i + 1] <= segments[i].x2)
                continue;
            
            // 답을 갱신합니다.
            ans++;
        }
        
        System.out.print(ans);
    }
}