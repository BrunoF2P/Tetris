package com.uneb.tetris;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.uneb.tetris.game.core.GameInitializer;
import com.uneb.tetris.architecture.mediators.GameMediator;
import javafx.scene.text.Font;

import java.util.Objects;

public class Main extends GameApplication {
    private GameMediator mediator;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1368);
        settings.setHeight(768);
        settings.setTitle("Tetris");
        settings.setVersion("1.0");
        settings.setScaleAffectedOnResize(true);
        settings.setPreserveResizeRatio(true);
        settings.setFullScreenAllowed(true);
        settings.setFullScreenFromStart(false);
        settings.setAppIcon("ui/icons/mipmap-mdpi/ic_game.png");
    }

    @Override
    protected void initGame() {
        Font.loadFont(Objects.requireNonNull(getClass().getResource("/assets/ui/fonts/thatsoundsgreat.ttf")).toExternalForm(), 10);
        mediator = GameInitializer.create(FXGL.getGameScene());
    }

    public static void main(String[] args) {

        launch(args);
    }
}