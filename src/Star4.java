public class Star4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
                // 앞쪽 공백은 i-1만큼 작아야 함
            }
            System.out.print("*");
                // 공백이 끝난 후 * 출력
            for (int j = 5; j >= 1; j--) {
                System.out.print(" ");
                // * 출력 후 오른쪽 공백 출력, 오른쪽 공백도 1씩 줄어야 함
            }
            System.out.println("*");
        }

    }
}
