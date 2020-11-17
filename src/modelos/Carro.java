/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas
 */
public class Carro implements Runnable{
    
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private ImageIcon imagen;
    private boolean bandera;
    private boolean bandera1 = false;

    ImageIcon imagenCarroFrente = new ImageIcon(getClass().getResource("../img/carro-frente.png"));
    ImageIcon imagenCarroDerecha = new ImageIcon(getClass().getResource("../img/carro-derecha.png"));
    ImageIcon imagenCarroIzquierda = new ImageIcon(getClass().getResource("../img/carro-izquierda.png"));

    public Carro(int x, int y, int ancho, int alto, ImageIcon imagen) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = imagen;
        this.bandera = true;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setBandera1(boolean nBandera) {
        this.bandera1 = nBandera;
    }
    
    public boolean getBandera1(){
        return this.bandera1;
    }

    @Override
    public void run() {
        int cont = 0;
        while(this.bandera){
            try {
                
                    if(bandera1 && cont < 5){
                        Thread.sleep(100);
                        this.setImagen(imagenCarroDerecha);
                        Thread.sleep(100);
                        this.setImagen(imagenCarroFrente);
                        Thread.sleep(100);
                        this.setImagen(imagenCarroIzquierda);
                        Thread.sleep(100);
                        this.setImagen(imagenCarroFrente);
                        cont++;
                    }
                    
            } catch (Exception ex) {
                    System.out.println("Error" + ex);
            }
        }
    }
    
}
