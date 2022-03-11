package blackjack.domain;

public class Gambler extends Player {

    private static final int BURST_CRITERIA = 21;

    public Gambler(final String name) {
        super(name);
    }

    public boolean isFinished(final CardDeck cardDeck) {
        final PlayingCard peekedCard = cardDeck.justPeek();
        final int currentResult = playingCards.getResultWithPeekCard(peekedCard);
        if (currentResult > BURST_CRITERIA) {
            playingCards.changeToBurst();
            return true;
        }
        return false;
    }

    @Override
    public void addCard(final CardDeck cardDeck) {
        playingCards.addCard(cardDeck.getCard());
    }

    @Override
    public int getSumOfCards() {
        return super.getSumOfCards();
    }
}
