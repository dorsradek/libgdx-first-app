package pl.dors.radek;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyFirstApp extends ApplicationAdapter {

    private SpriteBatch spriteBatch;
    private Texture texture;
    private BitmapFont bitmapFont;

    @Override
    public void create() {
        texture = new Texture("badlogic.jpg");
        spriteBatch = new SpriteBatch();
        bitmapFont = new BitmapFont();
        bitmapFont.setColor(Color.RED);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        spriteBatch.draw(texture, 100, 100);
        bitmapFont.draw(spriteBatch, "Hello world!", 400, 400);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        texture.dispose();
        bitmapFont.dispose();
    }
}
