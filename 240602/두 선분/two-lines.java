import java.util.Scanner;

public class Main {
    public static int x1, x2, x3, x4;

    public static boolean intersecting(int x1, int x2, int x3, int x4) {
        // 겹치지 않는 경우에 대한 처리를 먼저 진행합니다.
        if(x2 < x3 || x4 < x1)
            return false;
        // 나머지는 전부 겹치는 경우라고 볼 수 있습니다.
        else
            return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        x1 = sc.nextInt();
        x2 = sc.nextInt();
        x3 = sc.nextInt();
        x4 = sc.nextInt();
        
        // 겹치는지를 확인합니다.
        if(intersecting(x1, x2, x3, x4))
            System.out.print("intersecting");
        else
            System.out.print("nonintersecting");
    }
}