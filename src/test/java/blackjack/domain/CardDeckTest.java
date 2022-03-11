package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardDeckTest {

    @Test
    @DisplayName("카드덱 생성 테스트")
    void deck_create() {
        assertThatCode(
            CardDeck::new
        ).doesNotThrowAnyException();
    }
}
