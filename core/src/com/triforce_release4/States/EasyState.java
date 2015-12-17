package com.triforce_release4.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.triforce_release4.HUD;
import com.triforce_release4.TbMenu;
import com.triforce_release4.TbText;
import com.triforce_release4.TriForceRelease4;

/**
 * Created by Matthew on 12/9/2015.
 */
public class EasyState implements Screen, InputProcessor{
    TriForceRelease4 triForceRelease4;

    private TextureAtlas textureAtlas;
    private Animation animation;
    private float elapsedTime = 0f;

    SpriteBatch batch;
    Stage stage;

    TbMenu tbMenu;
    TextButton TbBack;

    public EasyState(TriForceRelease4 triForceRelease4){ //References the main class.
        this.triForceRelease4=triForceRelease4;
        triForceRelease4.hud = new HUD(triForceRelease4.batch);
    }

    public void create(){
        batch = new SpriteBatch();
        stage = new Stage();
        tbMenu= new TbMenu();
        Skin skin = tbMenu.getSkin();//calls skin
        TbBack = new TbText("Back", skin);
        TbBack.setPosition(0, 0);
        textureAtlas = new TextureAtlas(Gdx.files.internal("Megaman.pack"));
        animation = new Animation(1f/6f, textureAtlas.getRegions());
        stage.addActor(TbBack);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {
        create();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 0, 1); //Yellow background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        triForceRelease4.hud.stage.draw(); //Draw the hud.
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.begin();
        batch.draw(animation.getKeyFrame(elapsedTime,true),150,180);
        batch.end();
        if(TbBack.isPressed()){
            triForceRelease4.currentState = TriForceRelease4.GameState.PLAY;
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
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        textureAtlas.dispose();

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
