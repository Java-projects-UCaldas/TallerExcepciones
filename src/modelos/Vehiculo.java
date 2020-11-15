package modelos;

import control.VehiculoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

/**
 * @author
 * @version 1.0
 */
public class Vehiculo implements Runnable {
    
    private String llantas;
    private int motor;
    private String estado;
    private int velocidadPermitidaLlantas;
    private int velocidadPermitidaMotor;
    private int velocidadActual;
    private int encendido;
    private boolean patina;
    private boolean accidentado;
    private JLabel jLabelEstado;
    private JLabel jLabelMensaje;
    private boolean bandera;

    
    public Vehiculo(){
        
    }
    
    public Vehiculo(String llantas, int motor){

        this.llantas = llantas;
        this.motor = motor;
        this.estado = "";
        this.velocidadPermitidaLlantas = asignarVelocidadLlantas(llantas);
        this.velocidadPermitidaMotor = asignarVelocidadMotor(motor);
        this.patina = false;
        this.accidentado = false;
        this.encendido = 0;
        
    }

    public boolean getPatina(){
        return this.patina;
    }

    public boolean getAccidentado(){
        return this.accidentado;
    }
    
    public String getEstado(){
        return this.estado;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void setJLabelEstado(JLabel estado){
        this.jLabelEstado = estado;
    }
    
    public void encender() throws VehiculoException {
        if (this.encendido == 0){
            this.encendido = 1;
            this.estado = "Encendido";
        }
        else{
            throw new VehiculoException("El vehículo ya se encuentra encendido");
        }
    }

    public void apagar() throws VehiculoException {
        if(this.encendido == 1){
            this.encendido = 0;
        }
        else if(this.encendido == 0){
            throw new VehiculoException("El vehículo ya se encuentra apagado");
        }
        else if(this.velocidadActual > 60){
            this.accidentado = true;
            throw new VehiculoException("El vehículo se accidentó por apagarse con una velocidad mayor a 60 Km/h");
        }
    }

    public void acelerar(int aceleracion) throws VehiculoException{
        if(aceleracion > this.velocidadPermitidaMotor){
            this.accidentado = true;
            throw new VehiculoException("El Vehículo se accidentó por exceso de velocidad permitido para el motor");
        }
        else if((this.velocidadActual + aceleracion) > this.velocidadPermitidaMotor){
            this.accidentado = true;
            throw new VehiculoException("El Vehículo se accidentó por exceso de velocidad permitido para el motor");
        }
        else if((this.velocidadActual + aceleracion) <= this.velocidadPermitidaMotor){
            this.velocidadActual += aceleracion;
        }
        else if((this.velocidadActual + aceleracion) > this.velocidadPermitidaLlantas){
            this.patina = true;
            throw new VehiculoException("El vehículo patinó por exceso de velocidad permitida para las llantas");
        }
    }

    public void detener(int intensidad) throws VehiculoException{
            if(this.velocidadActual == 0){
                throw new VehiculoException("El carro ya se encuentra detenido");
            }
            else if(this.velocidadActual > this.velocidadPermitidaLlantas && intensidad < this.velocidadActual){
                this.patina = true;
                throw new VehiculoException("El vehículo patinó por llevar una velocidad mayor a la permitida por sus llantas");
            }
            else if(this.velocidadActual < intensidad){
                this.patina = true;
                throw new VehiculoException("El vehículo patinó por frenar con una intensidad mayor a la velocidad actual");
            }
    }

    public int asignarVelocidadLlantas(String llantas){
        int velocidadAsignar = 0;

        switch(llantas.toUpperCase()){
            case "BUENAS":
                velocidadAsignar = 110;
            case "BONITAS":
                velocidadAsignar = 70;
            case "BARATAS":
                velocidadAsignar = 50;
        }
        return velocidadAsignar;
    }

    public int asignarVelocidadMotor(int motor){
        int velocidadAsignar = 0;

        switch(motor){
            case 1000:
                velocidadAsignar = 110;
            case 2000:
                velocidadAsignar = 160;
            case 3000:
                velocidadAsignar = 220;
        }
        return velocidadAsignar;
    }

    @Override
    public void run() {
        while(this.bandera){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Error" + ex.getMessage());
            }
            
        }
    }
}
