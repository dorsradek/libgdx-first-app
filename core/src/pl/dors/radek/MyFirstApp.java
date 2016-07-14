package pl.dors.radek;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class MyFirstApp extends ApplicationAdapter {

    private Music music;
    private Sound sound;

    private OrthographicCamera camera;

    private SpriteBatch spriteBatch;
    private Texture texture;
    private BitmapFont bitmapFont;
    private GameObject gameObject1;
    private GameObject gameObject2;
    private float timeHelper;

    @Override
    public void create() {
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.play();

        sound = Gdx.audio.newSound(Gdx.files.internal("collision.mp3"));

        camera = new OrthographicCamera(800, 600);
        texture = new Texture("badlogic.jpg");
        spriteBatch = new SpriteBatch();
        bitmapFont = new BitmapFont();
        bitmapFont.setColor(Color.RED);

        gameObject1 = new GameObject(texture);
        gameObject1.x = 50;
        gameObject1.y = 50;
        gameObject1.width = gameObject1.getTexture().getWidth();
        gameObject1.height = gameObject1.getTexture().getHeight();

        gameObject2 = new GameObject(texture);
        gameObject2.x = 400;
        gameObject2.y = 400;
        gameObject2.width = gameObject2.getTexture().getWidth();
        gameObject2.height = gameObject2.getTexture().getHeight();
    }

    @Override
    public void render() {
        update();

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        spriteBatch.draw(gameObject1.getTexture(), gameObject1.x, gameObject1.y);
        spriteBatch.draw(gameObject2.getTexture(), gameObject2.x, gameObject2.y);


        bitmapFont.draw(spriteBatch, "Hello world!", 400, 400);
        spriteBatch.end();
    }

    private void update() {
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
        camera.position.set(gameObject1.x + gameObject1.width / 2, gameObject1.y + gameObject1.height / 2, 0);

        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            camera.zoom += 0.02F;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
            camera.zoom -= 0.02F;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            gameObject1.y += 500 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            gameObject1.y -= 500 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            gameObject1.x -= 500 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            gameObject1.x += 500 * Gdx.graphics.getDeltaTime();
        }
        if (gameObject1.overlaps(gameObject2)) {
            sound.play();
            System.out.println(MathUtils.random(10));

            if (MathUtils.random(10) > 5) {
                Gdx.app.exit();
            }
            gameObject1.x = 0;
            gameObject1.y = 0;
        }

        timeHelper += Gdx.graphics.getDeltaTime();
        if (timeHelper >= 0.02) {
            camera.rotate(0.20F);
            timeHelper = 0;
        }
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        texture.dispose();
        bitmapFont.dispose();
        music.dispose();
    }
}
