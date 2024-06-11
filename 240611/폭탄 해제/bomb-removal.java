import java.util.Scanner;

// Bomb 정보를 나타내는 클래스 선언
class Bomb{
    String unlockCode;
    char linearColor;
    int time;
    
    public Bomb(String unlockCode, char linearColor, int time) {
        this.unlockCode = unlockCode;
        this.linearColor = linearColor;
        this.time = time;
    }
};

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력
        String uCode = sc.next();
        char lColor = sc.next().charAt(0);
        int time = sc.nextInt();
        
        // Bomb 객체를 만들어 줍니다.
        Bomb b = new Bomb(uCode, lColor, time);

        // 결과를 출력합니다.
        System.out.println("code : " + b.unlockCode);
        System.out.println("color : " + b.linearColor);
        System.out.println("second : " + b.time);
    }
}