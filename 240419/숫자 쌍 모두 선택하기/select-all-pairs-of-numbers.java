import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static class Meeting {

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            meetings[i] = new Meeting(a, b);
        }

        meetings = Arrays.stream(meetings).sorted((a, b) -> {
            if (a.end == b.end) {
                return a.start - b.start;
            }
            return a.end - b.end;
        }).toArray(Meeting[]::new);

        Arrays.sort(meetings, Comparator.comparingInt(m -> m.end));

        List<Integer> rooms = new ArrayList<>();

        for (Meeting meeting : meetings) {
            boolean hasRoom = false;
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i) <= meeting.start) {
                    rooms.set(i, meeting.end); // 기존 회의실을 사용할 수 있음을 나타냄
                    hasRoom = true;
                    break;
                }
            }
            if (!hasRoom) {
                rooms.add(meeting.end); // 새로운 회의실을 추가함
            }
        }

        System.out.println(rooms.size());
    }
}