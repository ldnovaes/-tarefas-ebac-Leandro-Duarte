package br.ldnovaes.clientesv1;

import br.ldnovaes.clientesv1.controller.DetailController;
import br.ldnovaes.clientesv1.enums.ScreenChangeEnum;
import br.ldnovaes.clientesv1.enums.ScreenEnum;
import br.ldnovaes.clientesv1.interfaces.IObservador;
import br.ldnovaes.clientesv1.utills.ObservadorScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends Application {

    private static Stage stage;
    private static List<IObservador> observadores = new ArrayList<>();
    private static ObservadorScreen observadorScreen = new ObservadorScreen();
    private static ScreenChangeEnum acao;
    private Map<String, String> dados;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        registerObserver(observadorScreen); // registra observador de mudança de tela
        stage = primaryStage;
        stage.setTitle("Clientes v1");
        showScreen(ScreenEnum.MAIN);
        stage.show();
    }

    public static void changeScreen(ScreenEnum screenEnum, ScreenChangeEnum screenChangeEnum) throws IOException {
        acao = screenChangeEnum;
        notifyObservers();
        showScreen(screenEnum);
    }


    private static void showScreen(ScreenEnum screenEnum) throws IOException {
        Parent fxmlContent = FXMLLoader.load(Main.class.getResource(screenEnum.getFxmlFile()));
        Scene scene = new Scene(fxmlContent, screenEnum.getWidth(), screenEnum.getHeight());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setScene(scene);
    }


    public static void registerObserver(IObservador observer) {
        observadores.add(observer);
    }

    public static void unregisterObserver(IObservador observer) {
        observadores.remove(observer);
    }

    public static void notifyObservers() {
        for (IObservador observer:observadores) {
            observer.update(observer, acao);
        }
    }
}
