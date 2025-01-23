import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        HashSet<Integer> invited = new HashSet<>();
        HashSet<Integer>[] groups = new HashSet[g];
        invited.add(Integer.valueOf(1));
        for (int i = 0; i < g; i++) {
            st = new StringTokenizer(br.readLine());

            int groupSize = Integer.parseInt(st.nextToken());

            groups[i] = new HashSet<>();

            for (int j = 0; j < groupSize; j++) {
                int member = Integer.parseInt(st.nextToken());
                groups[i].add(Integer.valueOf(member));
            }
        }

        // 정렬해줘야할 듯, 정렬 기준은 1이 포함되어있으면서 그룹의 크기가 작은 순
        Arrays.sort(groups, (o1, o2) -> {
            if (o1.size() == o2.size()) {
                if (o1.contains(1)) {
                    return -1;
                } else if (o2.contains(1)) {
                    return 1;
                } else {
                    return 0;
                }
            }
            return o1.size() - o2.size();
        });

        for (int i = 0; i < g; i++) {
            HashSet<Integer> invitedMemberInGroup = new HashSet<>();
            for (Integer invitedMember: invited) {
                if (groups[i].contains(invitedMember)) {
                    invitedMemberInGroup.add(invitedMember);
                }
            }

            if (invitedMemberInGroup.size() == groups[i].size() - 1) {
                invited.addAll(groups[i]);
            }
        }

        System.out.println(invited.size());
    }
}
