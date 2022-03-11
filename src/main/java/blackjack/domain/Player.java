package blackjack.domain;

import java.util.List;

public abstract class Player {

    protected final String name;
    protected final PlayingCards playingCards = new PlayingCards();

    protected Player(final String name) {
        this.name = name;
    }

    public void getCard(final PlayingCard playingCard) {
        playingCards.addCard(playingCard);
    }

    public abstract void addCard(CardDeck cardDeck);

    public abstract boolean isFinished(final CardDeck cardDeck);

    public GameResult compare(final Player player) {
        return GameResult.of(this.getSumOfCards(), player.getSumOfCards());
    }

    public int getSumOfCards() {
        return playingCards.getCardSum();
    }

    public String getName() {
        return this.name;
    }
    public List<PlayingCard> getCards() {
        return playingCards.getPlayingCards();
    }

    @Override
    public String toString() {
        return "Player{" +
            "name='" + name + '\'' +
            ", playingCards=" + playingCards +
            '}';
    }

}
