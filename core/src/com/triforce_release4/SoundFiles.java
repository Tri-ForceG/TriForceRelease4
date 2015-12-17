package com.triforce_release4;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Created by Matthew on 11/18/2015.
 */
public class SoundFiles {
    public static Music backgroundMusic, megamanSound;
    public SoundFiles(){

    }
    public static void load(){
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("BackgroundMusic.mp3")); //Loads the file.
        megamanSound = Gdx.audio.newMusic(Gdx.files.internal("MegaManSound.mp3"));
        megamanSound.setVolume(1.0f);
        backgroundMusic.setLooping(true); //Loops the file.
        backgroundMusic.play(); //Plays the file.
        backgroundMusic.setVolume(1.0f); //Sets the volume.
    }
    }