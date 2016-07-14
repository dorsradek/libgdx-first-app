package pl.dors.radek;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Logger;

public class MyFirstApp extends ApplicationAdapter {
    private Sprite sprite;
    private Texture img;
    private int x;
    private int y;

    @Override
    public void create() {
        x = getScreenCenterX();
        y = getScreenCenterY();
        sprite = new Sprite(img);
        logger.error("Image size: [" + img.getWidth() + ", " + img.getHeight() + "]");
        logger.error("Image position: [" + x + ", " + y + "]");
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

    @Override
    public void dispose() {
    }

    private void drawOnScreen() {
        sprite.setPosition(
                sprite.getX() + 2.5f * Gdx.graphics.getDeltaTime(),
                sprite.getY() + 2.5f * Gdx.graphics.getDeltaTime());
        sprite.draw(batch);
    }

    private int getScreenCenterX() {
        int width = Gdx.app.getGraphics().getWidth();
        int imageWidth = img.getWidth();
        return (width / 2) - (imageWidth / 2);
    }

    private int getScreenCenterY() {
        int height = Gdx.app.getGraphics().getHeight();
        int imageHeight = img.getHeight();
        return (height / 2) - (imageHeight / 2);
    }
}
