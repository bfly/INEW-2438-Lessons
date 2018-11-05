package edu.dcccd;

import java.security.SecureRandom;

public class Main {

    private void go() {
        Hand hand = new Hand();
        Card card;
        int suit, rank;
        SecureRandom random = new SecureRandom();
        boolean[][] cards = new boolean[Card.SUIT_NAMES.length][Card.RANK_NAMES.length];

        // fill the hand with cards
        int i = 0;
        while( i < Card.SUIT_NAMES.length * Card.RANK_NAMES.length) {
            suit = random.nextInt(Card.SUIT_NAMES.length);
            rank = random.nextInt(Card.RANK_NAMES.length);
            if(!cards[suit][rank]) {
                hand.newCard(rank, suit);
                card = new Card(rank, suit);
                System.out.println((i+1) + ": " + card + " added to hand.");
                cards[suit][rank] = true;
                i++;
            }
        }
        System.out.println(hand);
        System.out.printf("Number of cards in hand: %d.\n", hand.getSize());
        System.out.println(hand.printFingers());

        // remove all of the cards from the hand
        i = 0;
        while( i <= Card.SUIT_NAMES.length * Card.RANK_NAMES.length) {
            suit = random.nextInt(Card.SUIT_NAMES.length);
            System.out.print((i+1) + ": " + Card.SUIT_NAMES[suit] + " requested, ");
            card = hand.playDown(suit);
            if (card != null) System.out.println( card + " removed.");
            else System.out.println("No card found to remove.");
            i++;
        }
        System.out.printf("Number of cards in hand: %d.\n", hand.getSize());
        System.out.println(hand.printFingers());
    }



    public static void main(String[] args) { new Main().go(); }

}
