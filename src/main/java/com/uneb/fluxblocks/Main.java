package com.uneb.fluxblocks;

import com.almasb.fxgl.app.ApplicationMode;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.uneb.fluxblocks.game.core.GameInitializer;
import com.uneb.fluxblocks.architecture.mediators.GameMediator;

import java.util.List;

public class Main extends GameApplication {
    private GameMediator mediator;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setTitle("FluxBlocks");
        settings.setVersion("1.0");

        settings.setWidth(1368);
        settings.setHeight(768);

        settings.setFullScreenAllowed(true);
        settings.setFullScreenFromStart(false);
        settings.setManualResizeEnabled(false);
        settings.setPreserveResizeRatio(true);
        settings.setScaleAffectedOnResize(true);

        settings.setCSSList(List.of("style.css"));
        settings.setFontGame("thatsoundsgreat.ttf");
        settings.setAppIcon("ui/icons/mipmap-mdpi/ic_game.png");

        settings.setTicksPerSecond(60);

        settings.setEntityPreloadEnabled(true);
        settings.setApplicationMode(ApplicationMode.DEVELOPER);

    }

    @Override
    protected void initGame() {
        mediator = GameInitializer.create(FXGL.getGameScene());
    }

    public static void main(String[] args) {

        launch(args);
    }
}