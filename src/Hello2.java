public class Hello2 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        for ( i =1; i <=5; i++) {
            sum = sum + i;

            if (i == 5) {
                break;
            }

        }
            System.out.println("i = " + i +", sum = " + sum);
        }


    }
