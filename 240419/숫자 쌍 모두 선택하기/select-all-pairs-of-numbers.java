import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
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

        PriorityQueue<Meeting> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.start != o2.start) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        pq.addAll(Arrays.asList(meetings));

        List<Integer> rooms = new ArrayList<>();

        while (!pq.isEmpty()) {
            Meeting meeting = pq.poll();
            boolean hasRoom = false;
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i) <= meeting.start) {
                    rooms.set(i, meeting.end);
                    hasRoom = true;
                    break;
                }
            }
            if (!hasRoom) {
                rooms.add(meeting.end);
            }
            rooms.sort(Integer::compareTo);
        }

        System.out.println(rooms.size());
    }
}