package beginner;

import java.util.Scanner;

public class Ccl {
    public static void main(String[] args) {
        System.out.println("계산한 수식을 입력하세요. ex) 2 + 3 * 4 / 2");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");

        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("값이 없습니다.");
        }

        // 만약 s[1] = + -> s[0] + s[2] -> result
        // s[1] 이 - * / 인 경우 각각 있음
        // result + s[3] + s[4] = result -> s[3] 기호에 따른 경우 4가지
        // s.length 까지 반복
        double result = Double.parseDouble(s[0]);

        for (int i = 1; i < s.length; i += 2) {
            String a = s[i];
            double next = Double.parseDouble(s[i + 1]);

            switch (a) {
                case "+":
                    result = add(result, next);
                    break;

                case "-":
                    result = sub(result, next);
                    break;

                case "*":
                    result = mul(result, next);
                    break;

                case "/":
                    result = div(result, next);
                    break;

                default:
                    throw new IllegalArgumentException("잘못된 연산자 입니다.");
            }
        }
        System.out.println("결과 : " + result);
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double mul(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        if (a % b != 0) {
            System.out.println("잘못된 값을 입력하셨습니다.");
        }
        return a / b;
    }
}