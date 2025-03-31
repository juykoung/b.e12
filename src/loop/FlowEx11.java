package loop;

import java.util.Scanner;

public class FlowEx11 {
    public static void main(String[] args) {
        System.out.println("주민번호 입력하세요. 123456-1234567");

        Scanner scanner = new Scanner(System.in);
        String regNo = scanner.nextLine();
        char gender = regNo.charAt(7);

        switch (gender) {
            case 1: case 3:
                switch (gender) {
                    case 1:
                        System.out.println("2000년 이전 출생 남자");
                        break;
                    case 3:
                        System.out.println("2000년 이후 출생 남자");
                }break; // 여기 안빼먹기 주의
            case 2 : case 4 :
                switch (gender) {
                    case 2 :
                        System.out.println("2000년 이전 출생 여자");
                        break;
                    case 4:
                        System.out.println("2000년 이후 출생 여자");
                }break;
            default:
                System.out.println("유효하지 않은 주민번호입니다");
        }
    }
}
