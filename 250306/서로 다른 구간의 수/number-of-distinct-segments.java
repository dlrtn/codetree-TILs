import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Segment {
    int x1, x2;

    public Segment(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }
};

class Point implements Comparable<Point> {
    int x, v, index;

    public Point(int x, int v, int index){
        this.x = x;
        this.v = v;
        this.index = index;
    }

    @Override
    public int compareTo(Point p) { // x 오름차순
        return this.x - p.x;
    }
};

public class Main {
    public static void main(String[] args) {
        Segment[] segments = new Segment[]{
            new Segment(1, 5),
            new Segment(4, 7),
            new Segment(3, 6),
            new Segment(9, 13),
            new Segment(8, 15),
            new Segment(12, 16),
        };
        int n = 6;
        
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
        // ArrayList에 대한 정렬에는 Collections를 이용합니다.
        Collections.sort(points);

        // 각 점을 순서대로 순회합니다.
        // 등장하고 아직 사라지지 않은
        // 선분을 hashset으로 관리합니다.
        HashSet<Integer> segs = new HashSet<>();

        int ans = 0; // 서로 다른 구간의 수를 저장합니다.
        for(int i = 0; i < 2 * n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;
            int index = points.get(i).index;

            // 시작점인 경우입니다.
            if(v == +1) {
                // 남아있는 선분이 없다면
                // 답을 갱신합니다.
                if(segs.size() == 0)
                    ans++;
                
                // 해당 선분 번호를 hashset에 넣어줍니다.
                segs.add(index);
            }

            // 끝점인 경우입니다.
            else {
                // 해당 선분을 제거합니다.
                segs.remove(index);
            }
        }
        
        // 서로 다른 구간의 수 = 2
        System.out.println(ans);
    }
}

