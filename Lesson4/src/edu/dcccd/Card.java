package edu.dcccd;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Card implements Comparable<Card> {

    private final int rank;
    private final int suit;

    static final String[] RANK_NAMES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    static final String[] SUIT_NAMES = {"Clubs", "Diamonds", "Hearts","Spades"};

    @Override
    public String toString() {
        return RANK_NAMES[rank] + " of " + SUIT_NAMES[suit];
    }

    //@Override
    public int compareTo(Card card) {
        if(this.suit == card.getSuit()) return (this.rank - card.getRank());
        return (this.suit - card.getSuit());
    }
}
