public class Star4_2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
                // 앞쪽 공백은 i-1만큼 작아야 함
            }
            System.out.print("*");
                // 공백이 끝난 후 * 출력    하는데 동시에 오른쪽 별, 공백이 찍혀야 함,,,,,,,,,&&
            /* 1. 앞쪽 공백은 i-1씩 늘어남
               2. * 출력
               3. 그리고, 오른쪽 공백 2-1-0-1-2 늘어남
               4. * 출력
             */
        }

    }
}
