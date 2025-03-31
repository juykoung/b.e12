package loop;

import java.util.Scanner;

public class FlowEx25 {
    public static void main(String[] args) {
        int num = 0, sum = 0;

        System.out.println("숫자를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt() ;

        while (num != 0) {
            sum += num % 10;
            System.out.println("sum =" + sum + ", num ="+ num);
            num /= 10;
        }
        System.out.println("각 자리수 합 :" + sum);
    }
}
