package Planet;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

//körszelet
public class Arc {
    private float centerX;
    private float centerY;
    private float radius;
    private float startAngle;
    private float angleStep;


    public Arc(float centerX, float centerY, float radius, float startAngle, float angelStep) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.startAngle = startAngle;
        this.angleStep = angelStep;
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(com.badlogic.gdx.graphics.Color.BLUE);
        shapeRenderer.arc(centerX, centerY, radius, startAngle, angleStep);
        shapeRenderer.end();
    }

    public float getStartAngel(){
        return startAngle;
    }

    public float getAngleStep(){
        return angleStep;
    }

    public void setStartAngle(float angle){
        startAngle = angle;
    }



}
