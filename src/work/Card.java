package work;

public class Card {
    static final int KIND_MAX = 4;
    static final int NUM_MAX = 13;

    static final int SPADE = 4;
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;
    int number;
    int kind;

    Card() { this(1,SPADE); }

    Card(int num, int kind) {
        this.number = num;
        this.kind = kind;
    }

    public String toString() {
        String[] kinds = {"CLOVER", "HEART", "DIAMOND", "SPADE"};
        String numbers = "0123456789XJQK";
        return "kind : " + kinds[this.kind] + ", number :" + numbers.charAt(this.number);
    }
}

/*class CardDeck {
    final int CARD_NUM = 52;
    Card[] cards = new Card[CARD_NUM];

    CardDeck() {
        for (int i = 0; i < CARD_NUM; i++) {

        }
    }

}

class Player {
    private static final int MAX_NAME_LENGTH = 20;
    final String NICK_NAME; // 한 번 초기화되면 변경 불가
    int money = 10000;
    int winTime = 0; // 승리 횟수
    int loseTime = 0; // 패배 횟수
    int prise = 0; // 획득한 상금

    public Player(String nickName) {
        if (nickName == null || nickName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("닉네임은 20자 이하만 가능합니다.");
        }
        NICK_NAME = nickName;
    }

    public void addWin() {
        ++winTime;
        prise += 100;}

    public void addLose() { ++loseTime; }
}

class Dealer {
    // 점수로 반환 -> int 할래 score 할래?
    public int evaluate() {

    }
}

class CardGame {
    public static void main(String[] args) {
        final int MAX_PLAYER = 4;

    }

}*/