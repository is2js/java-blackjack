package blackjack.domain.rule;

import blackjack.domain.card.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score implements Comparable<Score> {

    private static final int BUSTED = 0;
    private static final int BUST_THRESHOLD = 21;

    public static final Map<Integer, Score> SCORES;

    private int score;

    static {
        SCORES = new HashMap<>();

        for (int i = 0; i <= BUST_THRESHOLD; i++) {
            SCORES.put(i, new Score(i));
        }
    }

    private Score(int score) {
        this.score = score;
    }

    public static Score calculateScore(List<Card> cards) {
        int score = HandCalculator.calculate(cards);

        if (score > BUST_THRESHOLD) {
            return SCORES.get(BUSTED);
        }
        return SCORES.get(score);
    }

    public boolean isBusted() {
        return score == BUSTED;
    }

    public int getNumber() {
        return score;
    }

    @Override
    public int compareTo(Score target) {
        return Integer.compare(this.score, target.score);
    }
}