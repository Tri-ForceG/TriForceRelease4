package com.triforce_release4;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Matthew on 11/23/2015.
 */
public class HUD {
    public Stage stage;
    private Viewport vpHud; //Hud's viewport.

    private Integer nScore; //Score, coin, and time variables.
    private Integer nCoins;
    private Integer nTimer;

    Label lblScore;
    Label lblCoins;
    Label lblTimer;
                         //Labels to display.
    Label lblScoreWords;
    Label lblCoinsWords;
    Label lblTimerWords;

    public HUD(SpriteBatch spriteBatch){ //Thanks Cam & Brent Aureli (https://www.youtube.com/watch?v=7idwNW5a8Qs).
        nScore = 0; //Initialize each variable to 0.
        nCoins = 0;
        nTimer = 0;

        vpHud = new FitViewport(200, 400, new OrthographicCamera());
        stage = new Stage(vpHud, spriteBatch);

        Table tHudTable = new Table();
        tHudTable.top(); //Sets the table to the top of the screen.
        tHudTable.setFillParent(true); //Can easily be added to the stage.

        lblScore = new Label(String.format("%03d", nScore), new Label.LabelStyle(new BitmapFont(), Color.WHITE)); //3 decimal spaces.
        lblCoins = new Label(String.format("%03d", nCoins), new Label.LabelStyle(new BitmapFont(), Color.WHITE)); //White text.
        lblTimer = new Label(String.format("%03d", nTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        lblScoreWords = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblCoinsWords = new Label("COINS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblTimerWords = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        tHudTable.add(lblScoreWords).expandX().padTop(10); //Expands labels, fills the extra space.
        tHudTable.add(lblCoinsWords).expandX().padTop(10); //Padding gives extra space around the cell.
        tHudTable.add(lblTimerWords).expandX().padTop(10);
        tHudTable.row(); //Sets a new cell (row).
        tHudTable.add(lblScore).expandX();
        tHudTable.add(lblCoins).expandX();
        tHudTable.add(lblTimer).expandX();

        stage.addActor(tHudTable);
    }
}
