import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Segment {
    int x1, x2;

    public Segment(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}

class Point implements Comparable<Point> {
    int x, v, index;

    public Point(int x, int v, int index) {
        this.x = x;
        this.v = v;
        this.index = index;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;        // x 기준 오름차순 정렬 
    }
}

public class Main {    
    public static final int MAX_N = 100000;
    public static final int INT_MAX = Integer.MAX_VALUE;
    
    // 변수 선언
    public static int n;
    public static Segment[] segments = new Segment[MAX_N];
    
    public static int[] weights = new int[MAX_N]; // 각 선분을 제외했을 때 빠지게 되는 길이를 저장합니다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Segment(x1, x2);
        }   

        // 각 선분을 두 지점으로 나눠 담은 뒤,
        // 정렬해줍니다.
        // 이때 (x좌표, +1-1값, 선분 번호)
        // 형태로 넣어줍니다.
        // +1은 시작점
        // -1은 끝점을 뜻합니다.
        ArrayList<Point> points = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int x1 = segments[i].x1;
            int x2 = segments[i].x2;
            points.add(new Point(x1, +1, i)); // 시작점
            points.add(new Point(x2, -1, i)); // 끝점
        }

        // 정렬을 진행합니다.
        Collections.sort(points);

        // 각 점을 순서대로 순회합니다.
        // 각 선분을 제외했을 때 빠지게 되는 길이를
        // 각 weights[index]에 표시해줍니다.
        int totLength = 0;                        // 전체 길이의 합을 계산합니다.
        HashSet<Integer> segs = new HashSet<>();  // 현재 걸쳐져 있는 선분 번호를 관리합니다.
        int prevX = -1;                           // 바로 직전 x값을 관리합니다.
        for(int i = 0; i < 2 * n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;
            int index = points.get(i).index;

            // 걸쳐져 있는 선분의 수는 segs의 크기와 같습니다.
            int segCnt = segs.size();

            // 걸쳐져 있는 선분의 수가 1개 이상이라면
            // 전체 길이의 합을 갱신합니다.
            if(segCnt > 0)
                totLength += x - prevX;
            
            // 걸쳐져 있는 선분의 수가 정확히 1개라면
            // 해당 걸쳐져 있는 선분의 weights를 갱신합니다.
            if(segCnt == 1) {
                int targetIndex = new ArrayList<>(segs).get(0);
                weights[targetIndex] += x - prevX;
            }

            // 시작점인 경우입니다.
            if(v == +1) {
                // 걸쳐져 있는 선분 번호를 갱신합니다.
                segs.add(index);
            }

            // 끝점인 경우입니다.
            else {
                // 걸쳐져 있는 선분 번호를 제거합니다.
                segs.remove(index);
            }

            // 이전 x 값을 갱신해줍니다.
            prevX = x;
        }

        int minLength = INT_MAX;   // 특정 선분을 제외했을 때 빠지게 되는 길이 중 최솟값을 계산합니다.
        for(int i = 0; i < n; i++)
            minLength = Math.min(minLength, weights[i]);
        
        System.out.print(totLength - minLength);
    }
}
