import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
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
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        Collections.addAll(pq, meetings);

        PriorityQueue<Meeting> q = new PriorityQueue<>((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int count = 0;
        while (!pq.isEmpty()) {
            int end = 0;
            int size = pq.size();
            count++;
            for (int i = 0; i < size; i++) {
                Meeting meeting = pq.poll();

                if (end <= meeting.start) {
                    end = meeting.end;
                } else {
                    q.add(meeting);
                }
            }
            pq.addAll(q);
            q.clear();
        }

        System.out.println(count);
    }
}