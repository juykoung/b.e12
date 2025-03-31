public class Star8_1 {
    public static void main(String[] args) {
        int i = 1, j = 1;

        for (i = 1; i <= 5; i++) {
            for (j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (j = 1; j <= i; j++) {
                System.out.print("*");
                // i =2, j = 1 ->
            }
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
