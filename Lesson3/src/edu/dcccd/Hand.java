package edu.dcccd;

import lombok.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Hand {

    private List<Card> hand;
    private Card card;

    @Getter private int clubs;      // fingers
    @Getter private int diamonds;
    @Getter private int hearts;
    @Getter private int spades;

    private ListIterator<Card> li = null;

    Hand() {
        hand = new LinkedList<>();
        clubs = diamonds = hearts = spades = 0;
    }

    void newCard(int rank, int suit) {
        card = new Card(rank, suit);
        switch (Card.SUIT_NAMES[card.getSuit()]) {
            case "Clubs": {                       // club
                if ( add(card, clubs) ) { diamonds++; hearts++; spades++; return; }
                break;
            }
            case "Diamonds": {                    // diamonds
                if(add(card, diamonds)) {             hearts++; spades++; return; }
                break;
            }
            case "Hearts": {                      // hearts
                if(add(card, hearts)) {                         spades++; return; }
                break;
            }
            case "Spades": {                      // spades
                if(add(card, spades))                                     return;
                break;
            }
        }
    }

    private boolean add(Card card, int from) {
        li = hand.listIterator(from);
        while(li.hasNext()) {
            Card current = li.next();
            if(card.compareTo(current) == 0) return false;
            if(card.compareTo(current) < 0) {
                hand.add(hand.indexOf(current), card);
                return true;
            }
        }
        hand.add(card);
        return true;
    }

    Card playDown(int suit) {
        if(hand.size() == 0) return null;
        try {
            switch (Card.SUIT_NAMES[suit]) {
                case "Clubs": {    li = hand.listIterator(clubs);    break; }
                case "Diamonds": { li = hand.listIterator(diamonds); break; }
                case "Hearts": {   li = hand.listIterator(hearts);   break; }
                case "Spades": {   li = hand.listIterator(spades);   break; }
            }
        } catch (Exception e) {
            li = hand.listIterator(clubs);
        }

        if ( li.hasNext() ) card = li.next();
        else card = hand.get(clubs);
        switch (Card.SUIT_NAMES[card.getSuit()]) {
            case "Clubs": diamonds--; hearts--; spades--; break;
            case "Diamonds":          hearts--; spades--; break;
            case "Hearts":                      spades--; break;
        }
        hand.remove(card);
        return card;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Card hold = hand.get(0);
        sb.append(String.format("%-10s", Card.SUIT_NAMES[hold.getSuit()] + ":"));
        for (Card card : hand) {
            if(card.getSuit() != hold.getSuit()) {
                sb.setLength(sb.length() - 2);
                sb.append("\n");
                hold = card;
                sb.append(String.format("%-10s", Card.SUIT_NAMES[hold.getSuit()] + ":"));
            }
            sb.append(Card.RANK_NAMES[card.getRank()]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    int getSize() { return hand.size(); }

    String printFingers() {
        return String.format("Fingers: %s: %d, %s: %d, %s: %d, %s: %d",
            Card.SUIT_NAMES[0], clubs,  Card.SUIT_NAMES[1], diamonds,
            Card.SUIT_NAMES[2], hearts, Card.SUIT_NAMES[3], spades);
    }

}