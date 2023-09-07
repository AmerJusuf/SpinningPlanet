package Planet;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.mygdx.game.GameClass;

import java.awt.*;
import java.util.ArrayList;

//Planet from arcs (körszeletekből)
public  class Planet {
    private ArrayList<Arc> arcs;
     Texture circleTexture;

    public Planet(){
        create();
    }

    public void create() {
        arcs = new ArrayList<>();
        int numSectors = 30;
        float angleStep = 360.0f / numSectors;

        for (int i = 0; i < numSectors; i++) {
            float startAngle = i * angleStep;
            float endAngle = startAngle + angleStep;
            arcs.add(new Arc((float) 700, (float) -1500, 1800, startAngle, angleStep));
        }
    }

    public void draw(ShapeRenderer shapeRenderer){
        for (Arc arc : arcs) {
                arc.draw(shapeRenderer);
        }
    }

    public void update(float delta) {
        // Szektorok szögének frissítése
        for (Arc arc : arcs) {
            float newStartAngle = arc.getStartAngel() + (delta);
            arc.setStartAngle(newStartAngle);
        }
    }



}
