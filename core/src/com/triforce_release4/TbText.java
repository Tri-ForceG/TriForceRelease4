package com.triforce_release4;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Abraham on 2015-11-12.
 */
public class TbText extends TextButton {
    String _text;
    public TbText(String text, Skin skin) {
        super(text, skin);
        _text = text;
        this.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                System.out.println(_text);
            }
        });
    }
}