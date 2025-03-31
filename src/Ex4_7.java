public class Ex4_7 {
    public static void main(String[] args) {

        // 괄호 안의 내용을 조건(5)만큼 반복함 -> 임의의 수를 5개 뽑음
        for (int i = 1; i <= 8; i++) {
          //  System.out.println(Math.random());    // 0.0 ~ 0.9
          //  System.out.println(Math.random()*10); // 0.0~9.999
          //  System.out.println((int)(Math.random()*10)); // 0 ~9
          //  System.out.println((int)(Math.random()*10)+1); // 1 ~ 10
            System.out.println((int)(Math.random()*10)-5); // -5 ~ 4
        }
    }
}
