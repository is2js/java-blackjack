package blackjack.domain;

public class PlayingCard {
    private final Suit suit;
    private final Denomination denomination;

    private PlayingCard(final Suit suit, final Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public static PlayingCard of(Suit suit, Denomination denomination) {
        return new PlayingCard(suit, denomination);
    }

    public Suit getSuit() {
        return suit;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final PlayingCard that = (PlayingCard) object;

        if (suit != that.suit) {
            return false;
        }
        return denomination == that.denomination;
    }

    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + (denomination != null ? denomination.hashCode() : 0);
        return result;
    }
}