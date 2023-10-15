package org.example.dominio;

public class Porta {
    private boolean aberta;
    private String cor;
    private float dimensaoX;
    private float dimensaoY;
    private float dimensaoZ;

    public Porta(){
        this.aberta = false;
    }

    public void abre(){
        this.aberta = true;
    }

    public void fecha(){

        this.aberta = false;
    }

    public void pinta(String cor){
        this.cor = cor;
    }

    public boolean estaAberta(){
        return this.aberta;
    }

    public String getCor() {
        return cor;
    }

    public float getDimensaoX() {
        return dimensaoX;
    }

    public void setDimensaoX(float dimensaoX) {
        this.dimensaoX = dimensaoX;
    }

    public float getDimensaoY() {
        return dimensaoY;
    }

    public void setDimensaoY(float dimensaoY) {
        this.dimensaoY = dimensaoY;
    }

    public float getDimensaoZ() {
        return dimensaoZ;
    }

    public void setDimensaoZ(float dimensaoZ) {
        this.dimensaoZ = dimensaoZ;
    }
}
