import java.util.Scanner;

public class If_ex1 {
    public static void main(String[] args) {
        int score  ;
        char grade = ' ';

        System.out.println("점수를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();

        if (score >= 90) {
            grade = 'a';
        } else if (score >= 70) {
            grade = 'b';
        } else if (score >=60) {
            grade = 'c';
        } else {
            grade = 'f';
        }
        System.out.println("당신의 학점은 " + grade +"입니다.");
    }
}
