package modelos;

import control.VehiculoException;

/**
 * @author
 * @version 1.0
 */
public class Vehiculo {
    
    private String llantas;
    private int motor;
    private int estado;
    private int velocidadPermitidaLlantas;
    private int velocidadPermitidaMotor;
    private int velocidadActual;
    private boolean patina;
    private boolean accidentado;


    public Vehiculo(String llantas, int motor){

        this.llantas = llantas;
        this.motor = motor;
        this.estado = 0;
        this.velocidadPermitidaLlantas = asignarVelocidadLlantas(llantas);
        this.velocidadPermitidaMotor = asignarVelocidadMotor(motor);
        this.patina = false;
        this.accidentado = true;
    }

    public void encender() throws VehiculoException {
        if (this.estado == 0){
            this.estado = 1;
        }
        else{
            throw new VehiculoException("El vehículo ya se encuentra encendido");
        }
    }

    public void apagar() throws VehiculoException {
        if(this.estado == 1){
            this.estado = 0;
        }
        else if(this.velocidadActual > 60){
            throw new VehiculoException("El vehículo se accidentó por apagarse con una velocidad mayor a 60 Km/h");
        }
    }

    public void acelerar(int aceleracion) throws VehiculoException{
        if(aceleracion > this.velocidadPermitidaMotor){
            throw new VehiculoException("El Vehículo se accidentó por exceso de velocidad permitido para el motor");
        }
        else if((this.velocidadActual + aceleracion) > this.velocidadPermitidaMotor){
            throw new VehiculoException("El Vehículo se accidentó por exceso de velocidad permitido para el motor");
        }
        else if((this.velocidadActual + aceleracion) <= this.velocidadPermitidaMotor){
            this.velocidadActual += aceleracion;
        }
        else if((this.velocidadActual + aceleracion) > this.velocidadPermitidaLlantas){
            throw new VehiculoException("El vehículo patinó por exceso de velocidad permitida para las llantas");
        }
    }

    public void detener(int intensidad) throws VehiculoException{
            if(this.velocidadActual == 0){
                throw new VehiculoException("El carro ya se encuentra detenido");
            }
            else if(this.velocidadActual > this.velocidadPermitidaLlantas && intensidad < this.velocidadActual){
                throw new VehiculoException("El vehículo patinó por llevar una velocidad mayor a la permitida por sus llantas");
            }
            else if(this.velocidadActual < intensidad){
                throw new VehiculoException("El vehículo patinó por frenar con una intensidad mayor a la velocidad actual");
            }
    }

    public int asignarVelocidadLlantas(String llantas){
        int velocidadAsignar = 0;

        switch(llantas){
            case "Buenas":
                velocidadAsignar = 110;
            case "Bonitas":
                velocidadAsignar = 70;
            case "Baratas":
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
}
