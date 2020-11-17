package modelos;

import javax.swing.ImageIcon;

/**
 * Clase para pintar la via en el Panel
 * @author 
 * @version 1.0
 */
public class Via implements Runnable{
    
    private int x; 
    private int y;
    private int ancho;
    private int alto;
    private ImageIcon imagen;
    private boolean bandera = true;
    private int velocidad = 0;

    public Via(int x, int y, int ancho, int alto){
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = new ImageIcon(getClass().getResource("../img/via.jpg"));
        
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

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public boolean getBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void run() {
        while(this.bandera){
            try {
                    Thread.sleep(this.velocidad);
                    this.setX(this.getX() - 5);
            } catch (Exception ex) {
                    System.out.println("Error" + ex);
            }
        }
    }  
}
