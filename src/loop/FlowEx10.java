package loop;

import java.util.Scanner;

public class FlowEx10 {
    public static void main(String[] args) {
        int score = 0;
        char grade = ' ';

        System.out.println("점수를 입력하세요 (1~100)");

        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();

        switch (score/10) { // int / int = int 활용 -> ex. 80~89 사이는 8이 됨
            case 10:
            case 9:
                grade = 'a';
                break;
            case 8: case 7:
                grade = 'b';
                break;
            default:
                grade = 'f';
        }
        System.out.println("당신의 학점은"+grade+"입니다.");
    }
}
