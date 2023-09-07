package Planet;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.mygdx.game.GameClass;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

//Planet from arcs (körszeletekből)
public  class Planet {
    private ArrayList<Arc> arcs;
     Texture circleTexture;

    public Planet(){
        create();
    }

    public void create() {
        arcs = new ArrayList<>();
        int numSectors = 60;
        float angleStep = 360.0f / numSectors;

        for (int i = 0; i < numSectors; i++) {
            float startAngle = i * angleStep;
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
            if(newStartAngle > 360){
                newStartAngle-= 360;
            }
            arc.setStartAngle(newStartAngle);
        }
        createHoleRandomly();
    }

    private void createHole(){
        boolean holeCreated = false;
            for(int i = 0; i< arcs.size(); i++){
                if(!holeCreated) {
                    if (arcs.get(i).getStartAngel() > 30 && arcs.get(i).getStartAngel() < 100) {
                        arcs.remove(arcs.get(i));
                        holeCreated = true;
                    }
                }
            }
    }

    public void createHoleRandomly(){
        Random rand = new Random();
        int randomNum = rand.nextInt(100);
        if(randomNum == 1){
            createHole();
        }
    }

    public boolean isHoleNextToArc(Arc arc){
        //angel and angelstep => next arc's angel
        //is there arc in arcs with nextAngel...
        return true;
    }

}
