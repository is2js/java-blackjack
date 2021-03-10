package blackjack.domain;

import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.Map;

public class Player extends Gamer {

    private static final String GET_CARD = "y";
    private static final String ERROR_Y_OR_N = "y 혹은 n 만 입력하여 주십시오.";
    private static final String PATTERN_Y_OR_N = "[yn]";
    private static final int START_BETTING_MONEY = 0;

    private String result;

    public Player(String name) {
        super(name);
        this.bettingMoney = new BettingMoney(START_BETTING_MONEY);
    }

    public Player(String name, String bettingMoney) {
        super(name);
        this.bettingMoney = new BettingMoney(bettingMoney);
    }

    @Override
    public boolean canReceiveCard() {
        return !state.isFinished();
    }

    public Boolean continueDraw(Deck deck) {
        OutputView.noticeGetMoreCard(getName());
        String draw = InputView.isContinueDraw();
        if (isDrawCard(draw)) {
            receiveCard(deck.dealCard());
            OutputView.printPlayerInfo(this);
            return true;
        }
        state = state.stay();
        return false;
    }

    private Boolean isDrawCard(String draw) {
        if (!draw.matches(PATTERN_Y_OR_N)) {
            throw new IllegalArgumentException(ERROR_Y_OR_N);
        }
        return draw.equals(GET_CARD);
    }

    public void recordMatchResult(Result result) {
        if (result == Result.WIN) {
            this.result = Result.LOSE.getMessage();
        } else if (result == Result.LOSE) {
            this.result = Result.WIN.getMessage();
        } else if (result == Result.DRAW) {
            this.result = Result.DRAW.getMessage();
        }
    }

    public String getResult() {
        return result;
    }

    public void judgeVictory(Map<String, Integer> dealerHistory, int dealerPoint) {
        int playerPoint = getPoint();

        Result result = Result.getInstance(playerPoint, dealerPoint);
        inputMatchResult(dealerHistory, result.name());
        recordMatchResult(result);
    }

    private void inputMatchResult(Map<String, Integer> dealerHistory, String result) {
        dealerHistory.put(result, dealerHistory.get(result) + 1);
    }

    public int getMoney() {
        return this.bettingMoney.getBettingMoney();
    }

    public void giveMoney(String enterMoney) {
        bettingMoney.giveMoney(new BettingMoney(enterMoney));
    }
}
