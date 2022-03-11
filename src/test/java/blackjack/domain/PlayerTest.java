package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("겜블러 생성 테스트")
    void gambler_create() {
        // given
        String expected = "pobi";
        final Player pobi = new Gambler(expected);

        // when
        String actual = pobi.getName();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("딜러 생성 테스트")
    void dealer_create() {
        // given
        String expected = "딜러";
        final Player dolbum = new Dealer();

        // when
        String actual = dolbum.getName();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
