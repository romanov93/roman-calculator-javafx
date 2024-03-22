package ru.romanov.romancalc.quote;

import org.junit.jupiter.api.*;
import ru.romanov.romancalc.quotes.LatinQuotesStorage;
import ru.romanov.romancalc.quotes.LatinQuotesStorageImpl;
import ru.romanov.romancalc.quotes.Quote;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Random.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class LatinQuotesStorageTest {


    private LatinQuotesStorage latinQuotesStorage;

    @BeforeAll
    void prepareQuotesStorage() {
        latinQuotesStorage = new LatinQuotesStorageImpl();
    }


    @RepeatedTest(20)
    void quotesShouldHaveTextAndTranslation() {
        Quote randomQuote = latinQuotesStorage.getRandomQuote();
        assertThat(randomQuote.getLatinText()).isNotNull();
        assertThat(randomQuote.getTranslate()).isNotNull();
    }

    @RepeatedTest(10)
    void nextQuoteShouldBeNotEqualToCurrent() {
        Quote currentQuote = latinQuotesStorage.getRandomQuote();
        Quote nextQuote = latinQuotesStorage.getNextQuote();
        assertThat(currentQuote).isNotEqualTo(nextQuote);
    }

}