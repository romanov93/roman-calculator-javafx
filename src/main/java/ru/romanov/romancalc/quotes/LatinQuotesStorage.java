package ru.romanov.romancalc.quotes;

public interface LatinQuotesStorage {
    Quote getRandomQuote();
    Quote getNextQuote();
}
