package com.triforce_release4;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.triforce_release4.States.EasyState;
import com.triforce_release4.States.HardState;
import com.triforce_release4.States.ImpossState;
import com.triforce_release4.States.InstructState;
import com.triforce_release4.States.MainMenuState;
import com.triforce_release4.States.MediumState;
import com.triforce_release4.States.PlayState;

public class TriForceRelease4 extends Game {
	MainMenuState mainMenuState; //Instances of the other classes to call.
	PlayState playState;
	InstructState instructState;
	EasyState easyState;
	MediumState mediumState;
	HardState hardState;
	ImpossState impossState;

	public SpriteBatch batch;
	public HUD hud; //Instance of the hud.

	public enum GameState{           //http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
		MENU, PLAY , INSTRUCT,       //http://www.kilobolt.com/day-10-gamestates-and-high-score.html
		EASY, MEDIUM, HARD,          //http://ics3ui.sgrondin.ca/ss23/LibGDX.html
	    IMPOSSIBLE, PAUSE            //Different states.
	}

	public GameState currentState; //Current state.

	public void updateState(){ //Updates to different states based on what the current one is.
		if(currentState==GameState.MENU){
			setScreen(mainMenuState);
		}else if(currentState==GameState.PLAY){
			setScreen(playState);
		}else if(currentState==GameState.INSTRUCT){
			setScreen(instructState);
		}else if(currentState==GameState.PAUSE){
		}else if(currentState==GameState.EASY){
			setScreen(easyState);
		}else if(currentState==GameState.MEDIUM){
			setScreen(mediumState);
		}else if(currentState==GameState.HARD){
			setScreen(hardState);
		}else if(currentState==GameState.IMPOSSIBLE){
			setScreen(impossState);
		}
	}

	@Override
	public void create () {
		batch = new SpriteBatch();

		mainMenuState = new MainMenuState(this);
		playState = new PlayState(this);
		instructState = new InstructState(this);
		easyState = new EasyState(this);
		mediumState = new MediumState(this);
		hardState = new HardState(this);
		impossState = new ImpossState(this);

		SoundFiles.load(); //Loads the music file in the BackgroundMusic class, and then plays it based on the criteria there.

		currentState = GameState.MENU; //Set the current state to the main menu, and update it.
		updateState();
	}

	//If you include this render, it will display whatever is here, and not the render in the other classes.
	//@Override
	//public void render () {
	//Gdx.gl.glClearColor(1, 0, 0, 1);
	//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	//}
}
