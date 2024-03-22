package ru.romanov.romancalc.alerts;

// Класс, выводящий сообщения пользователю при некорректных действиях
public interface AlertsManager {

    // Невозможно записать отрицательное число римскими цифрами
    void showNegativeAlert();

    // Невозможно записать римскими цифрами число больше 3.999.999
    void showBigSizeAlert(long bigNumber);

    // Некорректный набор рисмкого числа
    void showWrongNumberFormatAlert(String wrongRomanNumber);

    // Оркугление результата потому что римскими числами нельзя записать доли меньше чем 1/1728
    void showRoundingAlert(String round);
}