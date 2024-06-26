package ru.romanov.romancalc.quotes;

import java.util.concurrent.ThreadLocalRandom;

public class LatinQuotesStorageImpl implements LatinQuotesStorage{

    private final Quote[] quotes = getQuotesArray();

    private int currentQuoteIndex;

    @Override
    public Quote getRandomQuote() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, quotes.length);
        currentQuoteIndex = randomIndex;
        return quotes[randomIndex];
    }

    @Override
    public Quote getNextQuote() {
        if (currentQuoteIndex == quotes.length - 1) {
            currentQuoteIndex = 0;
        } else {
            currentQuoteIndex++;
        }
        return quotes[currentQuoteIndex];
    }

    private Quote[] getQuotesArray() {
        Quote[] quotes = new Quote[20];
        quotes[0] = new Quote("«Radices litterarum amarae sunt, fructus dulces»",
                "(Корень учения горек, а плоды его сладки)");
        quotes[1] = new Quote("«Accidit in puncto, quod non speratur in anno»",
                "(В один миг случается то, на что не надеешься и годами)") ;
        quotes[2] = new Quote("«Felix qui potuit rerum cognoscere causas»",
                "(Счастлив тот, кто cмог познать суть вещей)");
        quotes[3] = new Quote("«Festinationis comites sunt error et poenitentia»",
                "(Спутники поспешности — ошибка и раскаяние)");
        quotes[4] = new Quote("«Dum vitant stulti vitia, in contraria currunt»",
                "(Глупые, избегая ошибок, впадают в другие ошибки)");
        quotes[5] = new Quote("«Quid quid latine dictum sit, altum viditur»",
                "(Все, что сказано на латыни, кажется мудростью)");
        quotes[6] = new Quote("«E fructu arbor cognoscitur»",
                "(Дерево узнается по плоду)");
        quotes[7] = new Quote("«Labor recedet, bene factum non abscedet»",
                "(Трудности уйдут, а благое дело останется)");
        quotes[8] = new Quote("«Fortes fortuna juiat»",
                "(Фортуна помогает смелым)");
        quotes[9] = new Quote("«Experentia est optima magistra»",
                "(Опыт есть лучший учитель)");
        quotes[10] = new Quote("«Una hirundo ver non facit»",
                "(Одна ласточка весны не делает)");
        quotes[11] = new Quote("«Malum consilium est, quod mutari non potest»",
                "(Плохо то решение, которое не может быть изменено)");
        quotes[12] = new Quote("«Manifestum non eget probatione»",
                "(Очевидное не нуждается в доказательствах)");
        quotes[13] = new Quote("«Prius quam exaudis ne judices»",
                "(Не суди, не выслушав)");
        quotes[14] = new Quote("«Miser, qui nunquam miser»",
                "(Несчастен тот, кто никогда не бывает несчастным)");
        quotes[15] = new Quote("«Nulla regula sine exceptione»",
                "(Нет правил без исключений)");
        quotes[16] = new Quote("«Dimidium facti, qui coepit, habet»",
                "(Начало - половина дела)");
        quotes[17] = new Quote("«Omne nimium nocet»",
                "(Все излишнее вредит)");
        quotes[18] = new Quote("«Paulatim summa petuntur»",
                "(Не сразу достигаются вершины)");
        quotes[19] = new Quote("«Incertus animus dimidium sapientiae est»",
                "(Сомнение – половина мудрости)");
        return quotes;
        // quotes[] = new Quote("«»", "()");
    }
}
