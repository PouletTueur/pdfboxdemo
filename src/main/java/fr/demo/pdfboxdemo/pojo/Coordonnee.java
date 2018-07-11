package fr.demo.pdfboxdemo.pojo;

public class Coordonnee {

    private float x;

    private float y;
    
    public Coordonnee () {
        
    }
    
    public Coordonnee (float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public void setX (float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY (float y) {
        this.y = y;
    }

}
