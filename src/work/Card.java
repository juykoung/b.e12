package work;

public class Card {
    final int NUMBER;
    final String KIND;
    static int width;
    static int height;

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
    private String nickname;
    int money;
    int winTime;
    int loseTime;
    int prise;


}