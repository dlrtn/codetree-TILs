import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        EatingHistory[] eatingHistories = new EatingHistory[d];
        SickHistory[] sickHistories = new SickHistory[s];

        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            int personIndex = Integer.parseInt(st.nextToken());
            int cheeseIndex = Integer.parseInt(st.nextToken());
            int eatingTime = Integer.parseInt(st.nextToken());

            eatingHistories[i] = new EatingHistory(personIndex, cheeseIndex, eatingTime);
        }

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int personIndex = Integer.parseInt(st.nextToken());
            int sickTime = Integer.parseInt(st.nextToken());

            sickHistories[i] = new SickHistory(personIndex, sickTime);
        }

        boolean[] spoiledCheese = new boolean[m];
        for (int i = 0; i < m; i++) {
            List<Integer> eatingPeople = new ArrayList<>();
            for (int j = 0; j < eatingHistories.length; j++) {
                if (eatingHistories[j].cheeseIndex - 1 == i) {
                    eatingPeople.add(eatingHistories[j].personIndex);
                }
            }

            int count = 0;
            for (int j = 0; j < sickHistories.length; j++) {
                if (eatingPeople.contains(sickHistories[j].personIndex) && eatingHistories[sickHistories[j].personIndex].eatingTime <= sickHistories[j].sickTime) {
                    count++;
                }
            }

            if (count == s) {
                spoiledCheese[i] = true;
            }
        }

        boolean[] humanSick = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < d; j++) {
                if (spoiledCheese[i] && eatingHistories[j].cheeseIndex - 1 == i) {
                    humanSick[eatingHistories[j].personIndex - 1] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (humanSick[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static class EatingHistory {

        int personIndex;
        int cheeseIndex;
        int eatingTime;

        public EatingHistory(int personIndex, int cheeseIndex, int eatingTime) {
            this.personIndex = personIndex;
            this.cheeseIndex = cheeseIndex;
            this.eatingTime = eatingTime;
        }
    }

    private static class SickHistory {

        int personIndex;
        int sickTime;

        public SickHistory(int personIndex, int sickTime) {
            this.personIndex = personIndex;
            this.sickTime = sickTime;
        }
    }
}