package blackjack.domain.card;

import blackjack.domain.cardGenerator.CardGenerator;
import blackjack.domain.player.Player;
import java.util.Collections;
import java.util.Stack;

public class CardDeck {

    private final Stack<PlayingCard> playingCards;

    public CardDeck(final CardGenerator cardGenerator) {
        Stack<PlayingCard> playingCards = cardGenerator.generate();
        Collections.shuffle(playingCards);
        this.playingCards = playingCards;
    }

    public PlayingCard addCard() {
        return playingCards.pop();
    }

    public void drawTo(Player player) {
        player.getCard(playingCards.pop());
    }

    public PlayingCard pop() {
        return playingCards.pop();
    }
}
