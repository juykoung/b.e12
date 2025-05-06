
package work;

import java.util.*;

public class Card {
    static final int KIND_MAX = 4;
    static final int NUM_MAX = 13;

    static final int SPADE = 4;
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;
    int kind;
    int number;

    Card() { this(SPADE,1); }

    Card(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    public String toString() {
        String[] kinds = {"CLOVER", "HEART", "DIAMOND", "SPADE"};
        String numbers = "123456789XJQK";
        return kinds[this.kind - 1] + " " + numbers.charAt(this.number -1);
    }
}

class CardDeck {
    final int CARD_NUM = 52;
    Card[] cards = new Card[CARD_NUM];
    int currentIndex;

    CardDeck() {
        int i = 0;

        for (int k = Card.KIND_MAX; k > 0; k--) {
            for (int n = 0; n < Card.NUM_MAX; n++) {
                cards[i++] = new Card(k, n+1);
            }
        }
        currentIndex = 0;
    }

    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int j = (int) (Math.random() * cards.length);
            Card tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
        currentIndex = 0;
    }

    public Card pick(int index) {
        // index가 card[] index 사이여야 함
        if (index < 0 || index > CARD_NUM) { return null; }
        return cards[index];
    }
            // 중복제거 ai 도움 받음
    public Card pick() {
        if (currentIndex >= CARD_NUM) { return null; }
        return pick(currentIndex++);
    }
}

class Player {
    private static final int MAX_NAME_LENGTH = 20;
    final String NICK_NAME; // 한 번 초기화되면 변경 불가
    int money = 10000;
    int winTime = 0;     // 승리 횟수
    int loseTime = 0;    // 패배 횟수
    int prise = 0;       // 획득한 상금
    int score = 0;

    Card[] playerCards = new Card[5];

    public Player(String nickName) {
        if (nickName == null || nickName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("닉네임은 20자 이하만 가능합니다.");
        }
        NICK_NAME = nickName;
    }
    // 이거 있어야되나?
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

    // 점수평가 1)로티플 : 플레이어의 카드 종류가 다 같음? -> 같으면 10,J,Q,K,A로 이뤄짐?
    public int evaluate(Card[] playerCards) {
//        firstKind, new HashSet<>(Arrays.asList(royalCard)) -> ai 도움 받음
        boolean isFlush = true;
        int firstKind = playerCards[0].kind;
        for (int p=0; p < 5; p++) {
            if (playerCards[p].kind != firstKind) {
                isFlush = false;
                break;
            }
        }
        Set<Integer> royalCard = new HashSet<>(Arrays.asList(1,10,11,12,13));
        Set<Integer> cardNum = new HashSet<>();
        for (int i = 0; i < playerCards.length; i++) {
            cardNum.add(playerCards[i].number);
        }
        if (isFlush && cardNum.equals(royalCard)) {
        return 13;
        }

        Set<Integer> backCard = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        if (isFlush && cardNum.equals(backCard)) {
            return 12;
        }
        boolean isStraight = false;
        for (int i = 0; i < playerCards.length; i++) {
            if(playerCards[i].number == playerCards[i].number + 1)
            isStraight = true;
        }
        if (isFlush && isStraight) {
            return 11;
        }
        for (int i = 0; i < playerCards.length-1; i++) {
            if (playerCards[i].number == playerCards[i + 1].number) {
                return 10;
            }
        }
        //풀하우스 : 같은 숫자 3개 && 같은 숫자 2개 -> 9점 어떡하지...?
        //플러쉬 : 카드 5장 모두 무늬 같은 패
        if (isFlush) return 8;
        // 마운틴 : 모든 무늬가 같진 않음 && 10,J,Q,K,A 연달아 있음
        if (!isFlush && cardNum.equals(royalCard)) {
            return 7;
        }
        if (!isFlush && cardNum.equals(backCard)) {
            return 6;
        }
        for (int i = 0; i < playerCards.length-1; i++) {
            if (!isFlush && playerCards[i].number == playerCards[i + 1].number) {
                return 5;
            }
    }
        return 0;
    }

    public void distribute(Player[] players) {  // 매개변수 받는거 ai 도움 받음
        cardDeck.shuffle();
        // 플레이어에게 서로 다른 카드 5장을 나눠줌
        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].NICK_NAME + "의 카드 : ");
            for (int p = 0; p < 5; p++) {
                players[i].playerCards[p] = cardDeck.pick();
                System.out.print(players[i].playerCards[p]+", ");
            }
            System.out.println();
        }
    }
}

class CardGame {
    public static void main(String[] args) {
        final int MAX_PLAYER = 4;
        final int GAME_ROUND = 100;

        // 플레이어가 0~4명 사이가 아닐 동안 반복
//        플레이어가 0~4명이면 while문 종료하고 "게임을 시작합니다."
        System.out.print("게임에 참여할 인원을 입력해주세요.(2명이상 4명이하) ");
        int playerNum = 0;
        while (true) {
            Scanner input = new Scanner(System.in);
            playerNum = input.nextInt();
            if (2 <= playerNum && playerNum <= MAX_PLAYER) {
                System.out.println(playerNum + "명이 게임을 시작합니다.");
                break;
            }
            System.out.print("2~4명이 참여 가능합니다. 다시 입력해주세요.");
        }
        System.out.println();
        Player[] player = new Player[playerNum];

        // playerNum만큼 반복하여 플레이어의 닉네임을 받고, 그걸 player 객체마다 부여
        String userName = "";

        for (int i = 0; i < playerNum; i++) {
            System.out.print((i + 1) + "번째 플레이어의 이름을 입력하세요. ");
            Scanner input2 = new Scanner(System.in);
            userName = input2.nextLine();
            player[i] = new Player(userName);
        }
        System.out.print("참여 플레이어 : ");
        for (int i = 0; i < playerNum; i++) {
            if (i < playerNum - 1) {
                System.out.print(player[i].NICK_NAME + ", ");
            } else System.out.print(player[i].NICK_NAME);
        }
        System.out.println();

        Dealer dealer = new Dealer();

        for (int round = 1; round <= GAME_ROUND; round++) {
            dealer.distribute(player);

            for (int i = 0; i < playerNum; i++) {
                player[i].score = dealer.evaluate(player[i].playerCards);
                System.out.println(player[i].NICK_NAME + "의 점수 : " + player[i].score);
            }

            Arrays.sort(player, (p1, p2) -> Integer.compare(p2.score, p1.score));
            player[0].addWin();
            for (int i = 1; i < playerNum; i++) {
                player[i].addLose();
            }
        }
        System.out.println("===최종 결과===");
        for (int i = 0; i < playerNum; i++) {
            System.out.print((i + 1) + "위 : " + player[i].NICK_NAME + ", ");
        }
    }
}
