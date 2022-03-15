package blackjack.domain.player;

public class Gambler extends Player {

    public Gambler(final String name) {
        super(name);
    }

    @Override
    public boolean isDealer() {
        return false;
    }
}
