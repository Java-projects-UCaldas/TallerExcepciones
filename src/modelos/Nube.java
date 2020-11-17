package modelos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Clase para pintar Nubes en el Panel
 * @author 
 * @version 1.0
 */
public class Nube implements Runnable{
    
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private ImageIcon imagen;
    private boolean bandera;

    public Nube(int x, int y, int ancho, int alto, ImageIcon imagen) {
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

    public boolean getBandera() {
        return bandera;
    }

    public void setBandera(Boolean bandera) {
        this.bandera = bandera;
    }

    @Override
    public void run() {
        while(this.bandera){
            try {
                Thread.sleep(100);
                this.setX(this.getX() - 2);
                if(this.getX() == -40){
                    this.setX(650);
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

    }
    
}
