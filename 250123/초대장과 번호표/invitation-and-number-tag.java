import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        HashSet<Integer> invited = new HashSet<>();
        Queue<HashSet<Integer>> groups = new LinkedList<>();
        invited.add(Integer.valueOf(1));
        for (int i = 0; i < g; i++) {
            st = new StringTokenizer(br.readLine());

            int groupSize = Integer.parseInt(st.nextToken());

            HashSet<Integer> group = new HashSet<>();

            for (int j = 0; j < groupSize; j++) {
                int member = Integer.parseInt(st.nextToken());
                group.add(Integer.valueOf(member));

                groups.add(group);
            }
        }

        int count = 0;
        while (!groups.isEmpty()) {
            HashSet<Integer> group = groups.poll();
            HashSet<Integer> invitedMemberInGroup = new HashSet<>();

            for (Integer invitedMember : invited) {
                if (group.contains(invitedMember)) {
                    invitedMemberInGroup.add(invitedMember);
                }
            }

            if (invitedMemberInGroup.size() == group.size() - 1) {
                invited.addAll(group);
                count = 0;
            } else {
                groups.add(group);
                count++;
            }

            if (count == groups.size()) {
                break;
            }
        }

        System.out.println(invited.size());
    }
}
