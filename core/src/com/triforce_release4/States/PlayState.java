package com.triforce_release4.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.triforce_release4.SoundFiles;
import com.triforce_release4.TbMenu;
import com.triforce_release4.TbText;
import com.triforce_release4.TriForceRelease4;

/**
 * Created by Matthew on 11/10/2015.
 */
public class PlayState implements Screen, InputProcessor {

    TriForceRelease4 triForceRelease4;
    TbMenu tbMenu;
    Stage stage;
    TextButton TbEasy, TbMedium, TbHard, TbImposs, TbBack;

    SpriteBatch batch;

    public PlayState(TriForceRelease4 triForceRelease4){ //References the main class.
        this.triForceRelease4=triForceRelease4;
    }

    public void create(){
        batch = new SpriteBatch();
        stage = new Stage();
        tbMenu= new TbMenu();
        Skin skin = tbMenu.getSkin();//calls skin
        TbEasy= new TbText("Easy", skin);
        TbEasy.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 3*2);
        TbMedium= new TbText("Medium",skin);
        TbMedium.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 2 );
        TbHard = new TbText("Hard",skin);
        TbHard.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 3);
        TbImposs = new TbText("Impossible", skin);
        TbImposs.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 5);
        TbBack = new TbText("Back", skin);
        TbBack.setPosition(0, 0);
        stage.addActor(TbEasy);
        stage.addActor(TbMedium);
        stage.addActor(TbHard);
        stage.addActor(TbImposs);
        stage.addActor(TbBack);
        Gdx.input.setInputProcessor(stage); //Have to change the Input Processor when changing screens, or else you can still use the buttons from the Main Menu on the Play Screen.

    }

    @Override
    public void show() { //This is called when you set the screen to this class.
        create();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 1, 1); //Blue background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        batch.begin();
        batch.end();
        if(Gdx.input.justTouched()){ //When you click the screen, it plays the "hitmarker" sound.
            SoundFiles.megamanSound.play();
        }
        if(TbEasy.isPressed()){
            triForceRelease4.currentState = TriForceRelease4.GameState.EASY;
            triForceRelease4.updateState();
        }else if(TbMedium.isPressed()){
            triForceRelease4.currentState = TriForceRelease4.GameState.MEDIUM;
            triForceRelease4.updateState();
        }else if(TbHard.isPressed()){
            triForceRelease4.currentState = TriForceRelease4.GameState.HARD;
            triForceRelease4.updateState();
        }else if(TbImposs.isPressed()){
            triForceRelease4.currentState = TriForceRelease4.GameState.IMPOSSIBLE;
            triForceRelease4.updateState();
        }else if(TbBack.isPressed()){
            triForceRelease4.currentState = TriForceRelease4.GameState.MENU;
            triForceRelease4.updateState();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() { //This is called when the other screen is displayed.

    }

    @Override
    public void dispose() {
        batch.dispose();

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
