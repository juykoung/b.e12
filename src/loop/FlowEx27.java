package loop;

import java.util.Scanner;

public class FlowEx27 {
    public static void main(String[] args) {
        int num ;
        int sum = 0;
boolean flg = true;
        System.out.println("숫자를 입력하세요");

        while (flg) {
            System.out.println(">>");

            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();

            if (num != 0) {
                sum += num;
            } else {
                flg = false;
            }

        }
        System.out.println("합계 "+sum);
    }
}
