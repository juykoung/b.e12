package loop;

public class FlowEx23 {
    public static void main(String[] args) {
        int i = 5;

        while (i-- != 0) { // 후위형 -> 조건식이 평가된 후 i값 감소 -> 4~0까지 출력
            System.out.println(i);
        }
    }
}
