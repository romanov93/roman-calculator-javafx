package ru.romanov.romancalc.alerts;

import javafx.scene.control.Alert;

public class AlertsManagerImpl implements AlertsManager {

    @Override
    public void showNegativeAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText("В Риме не было отрицательных чисел");
        alert.setContentText("Результат невозможно записать римскими цифрами.");

        alert.show();
    }

    @Override
    public void showBigSizeAlert(long bigNumber) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText("Результат (" + bigNumber + ",...) невозможно записать римскими цифрами");
        alert.setContentText("Максимально возможное целое римское число: 3999999");
        alert.show();
    }

    @Override
    public void showWrongNumberFormatAlert(String wrongRomanNumber) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setHeaderText("Некорректная запись числа: " + wrongRomanNumber);
        alert.setContentText("Нарушены правила записи римских чисел");
        alert.show();
    }

    @Override
    public void showRoundingAlert(String round) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText("Ответ был округлен в меньшую сторону.");
        alert.setContentText("Произошло округление на: " + round + "...");
        alert.show();
    }
}