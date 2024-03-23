module ru.romanov.romancalc {
    requires javafx.controls;
    requires java.desktop;
    opens ru.romanov.romancalc;
    exports ru.romanov.romancalc;
    opens ru.romanov.romancalc.calculator;
    exports ru.romanov.romancalc.calculator;
    opens ru.romanov.romancalc.quotes;
    exports ru.romanov.romancalc.quotes;
    opens ru.romanov.romancalc.view;
    exports ru.romanov.romancalc.view;
    opens ru.romanov.romancalc.binder;
    exports ru.romanov.romancalc.binder;
    opens ru.romanov.romancalc.alerts;
    exports ru.romanov.romancalc.alerts;
    opens ru.romanov.romancalc.fxcomponents;
    exports ru.romanov.romancalc.fxcomponents;
    opens ru.romanov.romancalc.enums;
    exports ru.romanov.romancalc.enums;
    opens ru.romanov.romancalc.roman;
    exports ru.romanov.romancalc.roman;
}