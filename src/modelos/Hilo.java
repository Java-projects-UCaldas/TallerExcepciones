package modelos;

public class Hilo implements Runnable{

    private boolean salida;
    private String nombre;
    private Thread h;
    private int tiempo;


    public Hilo(String nombreHilo){
        this.nombre = nombreHilo;
        this.salida = false;
        this.tiempo = 1000;
    }

    public void inicia(Via nuevaVia){
        this.h = new Thread(nuevaVia, nombre);
        h.start();
    }
    public void parar(){
        this.salida = true;
    }

    public void setTiempo(int tiempo){
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        
        while(!salida){
            try {
                Thread.sleep(this.tiempo);
                System.out.println("tiempo: " + this.nombre);
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage()); 
            }
            
        }

    }
}