import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static final int MAX_G = 250000;
    public static final int MAX_N = 100000;
    
    public static int n, g;
    public static boolean[] invited = new boolean[MAX_N];
    public static HashSet<Integer>[] groups = new HashSet[MAX_G];
    public static ArrayList<Integer>[] peopleGroups = new ArrayList[MAX_N];
    public static Queue<Integer> q = new LinkedList<>();
    public static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        g = sc.nextInt();

        for(int i = 0; i < n; i++)
            peopleGroups[i] = new ArrayList<>();

        for(int i = 0; i < g; i++)
            groups[i] = new HashSet<>();

        for(int i = 0; i < g; i++) {
            int s = sc.nextInt();
            for(int j = 0; j < s; j++) {
                int x = sc.nextInt(); x--;
                groups[i].add(x);
                peopleGroups[x].add(i);
            }
        }

        q.add(0);
        invited[0] = true;
        while(!q.isEmpty()) {
            int x = q.poll();
            ans++;

            for(int i = 0; i < peopleGroups[x].size(); i++) {
                int gNum = peopleGroups[x].get(i);

                groups[gNum].remove(x);
                
                if(groups[gNum].size() == 1) {
                    int pNum = new ArrayList<>(groups[gNum]).get(0);
                    if(!invited[pNum]) {
                        invited[pNum] = true;
                        q.add(pNum);
                    }
                }
            }
        }

        System.out.print(ans);
    }
}