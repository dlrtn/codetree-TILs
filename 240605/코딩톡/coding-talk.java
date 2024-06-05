import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<ChattingLog> chattingLogs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String c = st.nextToken();
            int u = Integer.parseInt(st.nextToken());

            chattingLogs.add(new ChattingLog(c, u));
        }

        Map<String, Boolean> readMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String c = String.valueOf((char) ('A' + i));

            readMap.put(c, false);
        }

        if (chattingLogs.get(p - 1).unreadCount == 0) {
            return;
        }

        int start = 0;
        for (int i = 0; i < m; i++) {
            if (chattingLogs.get(i).unreadCount == chattingLogs.get(p - 1).unreadCount) {
                start = i;
                break;
            }

        }

        for (int i = start; i < m; i++) {
            readMap.put(chattingLogs.get(i).name, true);
        }

        readMap.forEach((k, v) -> {
            if (!v) {
                System.out.print(k + " ");
            }
        });


    }

    public static class ChattingLog {
        String name;
        int unreadCount;

        public ChattingLog(String name, int unreadCount) {
            this.name = name;
            this.unreadCount = unreadCount;
        }
    }
}