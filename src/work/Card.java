package work;

public class Card {
    final int NUMBER;
    final String KIND;

    Card() { this(1,"HEART"); }

    Card(int num, String kind) {
        NUMBER = num;
        KIND = kind;
    }

    public String toString() { return KIND + " " + NUMBER; }
}

class CardDeck {
    final int CARD_NUM = 52;
    Card[] cards = new Card[CARD_NUM];


}

class Player {
    private String nickname; // 20자 이하
    int money = 10000;
    int winTime;
    int loseTime;
    int prise;

    Player(String nickname, ) {
        this.nickname = nickname;
    }


}
class Dealer {
public socre/int? evaluate() {

}
}
