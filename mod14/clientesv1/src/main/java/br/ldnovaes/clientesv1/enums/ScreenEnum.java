package br.ldnovaes.clientesv1.enums;

import br.ldnovaes.clientesv1.Main;
import javafx.scene.Scene;

/**
 * @author ldnovaes
 */

public enum ScreenEnum {
    DETAIL("detail-view.fxml", 600, 400),
    MAIN("main-view.fxml", 600, 400);

    private final String fxmlFile;
    private final int width;
    private final int height;

    ScreenEnum(String fxmlFile, int width, int height) {
        this.fxmlFile = fxmlFile;
        this.width = width;
        this.height = height;
    }

    public String getFxmlFile() {
        return fxmlFile;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}