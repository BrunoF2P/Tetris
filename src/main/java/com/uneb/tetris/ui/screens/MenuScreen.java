package com.uneb.tetris.ui.screens;

import com.uneb.tetris.architecture.events.UiEvents;
import com.uneb.tetris.architecture.mediators.GameMediator;
import com.uneb.tetris.configuration.GameConfig;
import com.uneb.tetris.ui.UIFactory;
import com.uneb.tetris.ui.components.Button;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Objects;

public class MenuScreen {
    private final GameMediator mediator;
    private final VBox content;
    private final StackPane root;

    public MenuScreen(GameMediator mediator) {
        this.mediator = mediator;
        this.content = new VBox();
        this.root = new StackPane();

        root.setCursor(Cursor.NONE);

        setupLayout();
        initializeComponents();
    }

    private void setupLayout() {
        content.setAlignment(Pos.CENTER);
        content.getStyleClass().addAll("background", "content-box");
        content.setPrefSize(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);

        root.getStyleClass().add("background");
        root.getChildren().add(content);
        StackPane.setAlignment(content, Pos.CENTER);
    }

    private void initializeComponents() {
        Text title = UIFactory.createGameTitle("TETRIS");

        content.getChildren().addAll(
                title,
                createMenuButton("JOGAR", Button.ButtonType.PLAY, e -> mediator.emit(UiEvents.PLAY_GAME, null)),
                createMenuButton("RANKING", Button.ButtonType.RANKING, e -> mediator.emit(UiEvents.RANKING, null)),
                createMenuButton("OPÇÕES", Button.ButtonType.OPTIONS, e -> mediator.emit(UiEvents.OPTIONS, null)),
                createMenuButton("SAIR", Button.ButtonType.EXIT, e -> System.exit(0))
        );
    }

    private Button createMenuButton(String text, Button.ButtonType type, javafx.event.EventHandler<javafx.event.ActionEvent> action) {
        Button button = UIFactory.createButton(text, type);
        if (action != null) {
            button.setOnAction(action);
        }
        return button;
    }

    /**
     * Limpa os recursos e remove listeners para evitar vazamentos de memória.
     * Este método deve ser chamado quando a tela não for mais necessária.
     */
    public void destroy() {
        // Remove todos os botões e seus event handlers
        content.getChildren().forEach(node -> {
            if (node instanceof Button) {
                ((Button) node).setOnAction(null);
            }
        });

        // Limpa os nós filhos
        content.getChildren().clear();

        // Remove referência ao stylesheet
        root.getStylesheets().clear();
    }

    public Parent getNode() {
        return root;
    }
}