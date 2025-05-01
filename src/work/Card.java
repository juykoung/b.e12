package work;

import casting.Car;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

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

class CardDeck {
    final int CARD_NUM = 52;
    Card[] cards = new Card[CARD_NUM];

    CardDeck() {
        int i = 0;

        for (int k = Card.KIND_MAX; k > 0; k--) {
            for (int n = 0; n < Card.NUM_MAX; n++) {
                cards[i++] = new Card(k, n+1);
            }
        }
        }
    public void suffle () {
        for (int i = 0; i < cards.length; i++) {
            int j = (int) (Math.random() * cards.length);
            Card tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
    }

    public Card pick(int index) {
        // index가 card[] index 사이여야 함
        if (index < 0 || index > CARD_NUM) { return null; }
        return cards[index];
    }

    public Card pick() {
        int index = (int) (Math.random() * CARD_NUM);
        return pick(index);
    }
    }


class Player {
    private static final int MAX_NAME_LENGTH = 20;
    final String NICK_NAME; // 한 번 초기화되면 변경 불가
    final int MAX_PLAYER = 4;   // ?? 이게 여기 맞나,,? main 클래스 아닌가,,?
    int money = 10000;
    int winTime = 0;     // 승리 횟수
    int loseTime = 0;    // 패배 횟수
    int prise = 0;      // 획득한 상금

    public Player(String nickName) {
        if (nickName == null || nickName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("닉네임은 20자 이하만 가능합니다.");
        }
        NICK_NAME = nickName;
    }

    public Player() {
        NICK_NAME = "noName";
    }

    public void addWin() {
        ++winTime;
        prise += 100;
    }

    public void addLose() { ++loseTime; }
}

class Dealer {
    CardDeck cardDeck = new CardDeck();

    // 점수로 반환 -> int 할래 score 할래?
    public int evaluate() {

    }

    public void develop() {
        cardDeck.suffle();// 플레이어에게 서로 다른 카드 5장을 나눠줌
        for (int i = 0; i <; i++) {

        }
    }
}

class CardGame {
    public static void main(String[] args) {
        final int MAX_PLAYER = 4;
        final int MAX_CARD_DECK = 1;

        System.out.println("게임은 최대 4명까지 참여 가능합니다. 몇명이서 게임을 하나요?");
        Scanner plyerNum = new Scanner(System.in);
        int plyerNum =

        System.out.println("플레이어의 이름을 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();

        Player user = new Player();

    }

}