package ru.romanov.romancalc.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import ru.romanov.romancalc.AppStarter;
import ru.romanov.romancalc.binder.CalculatorBinderImpl;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainAppView extends StackPane {

    private final BorderPane borderPane = new BorderPane();
    private final CalculatorForm calculatorForm = new CalculatorForm();
    private final QuoteForm quoteForm = new QuoteForm();
    private final CalculatorBinderImpl binder = new CalculatorBinderImpl(calculatorForm, quoteForm);

    public MainAppView() throws FileNotFoundException {
        borderPane.setTop(calculatorForm);
        borderPane.setCenter(quoteForm);
        binder.addBindingToCalculatorButtons();

        getChildren().add(getAppBackgroundPicture());
        getChildren().add(borderPane);
    }

    private ImageView getAppBackgroundPicture() {
        InputStream inputStream = AppStarter.class.getClassLoader().getResourceAsStream("background.png");
        return new ImageView(new Image(inputStream));
    }

}