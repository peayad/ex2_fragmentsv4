package tutorials.androidstudio.fragmentsv4;

import processing.core.PApplet;

public class Sketch extends PApplet {
    public static int w, h;

    public void settings() {
//        size(600, 600);
        size(w,h);
    }

    public void setup() {
//      fullScreen();
    }

    public void draw() {
        if (mousePressed) {
            ellipse(mouseX, mouseY, 50, 50);
        }
    }
}