import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Human> pq = new PriorityQueue<>();
        ArrayList<Human> humanArrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int arriveTime = Integer.parseInt(st.nextToken());
            int runningTime = Integer.parseInt(st.nextToken());

            humanArrayList.add(new Human(i + 1, arriveTime, runningTime));
        }
        humanArrayList.sort(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.arriveTime - o2.arriveTime;
            }
        });

        pq.add(humanArrayList.get(0));
        humanArrayList.remove(0);

        int nowTime = 0;
        int maxWaitingTime = 0;
        while (!humanArrayList.isEmpty()) {
            if (nowTime == 0) {
                Human human = pq.poll();
                nowTime += human.arriveTime + human.runningTime;
            } else {
                for (int i = 0; i < humanArrayList.size(); i++) {
                    if (humanArrayList.get(i).arriveTime <= nowTime) {
                        pq.add(humanArrayList.get(i));
                    }
                }

                if (pq.isEmpty()) {
                    nowTime++;
                    continue;
                }

                Human human = pq.poll();
                maxWaitingTime = Math.max(maxWaitingTime, nowTime - human.arriveTime);
                nowTime += human.runningTime;

                humanArrayList.remove(human);

                pq.clear();
            }
        }

        System.out.println(maxWaitingTime);
    }

    public static class Human implements Comparable<Human> {
        int num;
        int arriveTime;
        int runningTime;

        public Human(int num, int arriveTime, int runningTime) {
            this.num = num;
            this.arriveTime = arriveTime;
            this.runningTime = runningTime;
        }

        @Override
        public int compareTo(Human o) {
            return this.num - o.num;
        }

        public void print() {
            System.out.println(this.num + " " + this.arriveTime + " " + this.runningTime);
        }
    }
}
