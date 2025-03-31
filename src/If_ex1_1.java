import java.util.Scanner;

public class If_ex1_1 {
    public static void main(String[] args) {
        int score  ;
        char grade = 'D', opt = 0;

        System.out.println("점수를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();
        System.out.println("당신의 점수는 " + score + " 입니다.");
        if (score >= 90) {
            grade = 'A';
            if (score >= 98) {
                opt = '+';
            } else if (score < 94) {
                opt = '-';
            }
        } else if (score >= 70) {
            grade = 'b';
            if (score >= 78) {
                opt = '+';
            } else if (score < 74) {
                opt = '-';
            }
        } else if (score >=60) {
            grade = 'c';
        }
        System.out.println("당신의 학점은 " + grade + opt+"입니다.");
    }
}
