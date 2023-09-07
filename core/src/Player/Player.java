package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameClass;

import javax.imageio.ImageReader;
import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Player extends InputAdapter {

    private ArrayList<Texture> catRunningImage;
    final int catWidth = 150;
    final int catHeight = 90;
    Point playerPos;
    int startX = 620;
    int startY = 290;
    ArrayList<String> imagePaths;

    int imageCounter = 0;
    int imageShifter = 1;
    long changeImageDelayer = 0;
    long delayValue = 10;

    public Player(){
       playerPos = new Point(startX,startY);
       setImagePathsList();
       setCatRunningImageTextures();
    }

    public void update(){
        handleIfJumped();
        handleRunningImage();
    }

    public void draw(SpriteBatch batch){
       batch.draw(catRunningImage.get(imageCounter),playerPos.x,playerPos.y,catWidth,catHeight);
   }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.SPACE) {
          playerPos.y +=110;
        }
        return true;
    }

    private void setImagePathsList(){
       imagePaths = new ArrayList<>();
       for(int i = 1; i <=8 ;i++){
           imagePaths.add("catRunningImage"+i+".png");
       }
    }

    private void  setCatRunningImageTextures(){
       catRunningImage = new ArrayList<>();
        for (String imagePath : imagePaths) {
            catRunningImage.add(new Texture(imagePath));
        }
    }

    private void handleIfJumped() {
        if (playerPos.y > startY) {
            playerPos.y -= 4;
        }
        if (playerPos.y < startY) {
            playerPos.y = startY;
        }
    }

    private void handleRunningImage(){
        changeImageDelayer++;
        if(changeImageDelayer == delayValue) {
            imageCounter+=imageShifter;
            if (imageCounter >= 7) {
                imageShifter = -1;
            }
            if(imageCounter <=0){
                imageShifter = 1;
            }
            changeImageDelayer = 0;
        }
    }

}
