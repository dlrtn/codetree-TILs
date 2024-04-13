import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<MeetingRoomReservation> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            arr.add(new MeetingRoomReservation(startTime, endTime));
        }

        arr.sort((o1, o2) -> {
            if (o1.endTime > o2.endTime) {
                return 1;
            } else if (o1.endTime < o2.endTime) {
                return -1;
            } else {
                return 0;
            }
        });

        int count = 0;

        int endTime = 0;
        for (int i = 0; i < n; i++) {
            if (endTime <= arr.get(i).startTime) {
                endTime = arr.get(i).endTime;
                count++;
            }
        }

        System.out.println(count);
    }

    public static class MeetingRoomReservation {

        int startTime;
        int endTime;

        public MeetingRoomReservation(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public void print() {
            System.out.println("startTime: " + this.startTime + " endTime: " + this.endTime);
        }
    }
}