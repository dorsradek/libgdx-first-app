package pl.dors.radek;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by rdors on 2016-07-14.
 */
public class GameObject extends Rectangle {

    private Texture texture;

    public GameObject(Texture texture) {
        this.texture = texture;
    }

    public Texture getTexture() {
        return texture;
    }
}
