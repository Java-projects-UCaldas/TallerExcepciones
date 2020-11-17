package control;
/**
 * Excecpion propia para el manejo de errores en la
 * clase vehículo
 * @author 
 * @version 1.0
 */
public class VehiculoException extends Exception{
    
    public VehiculoException(String mensaje){
        super(mensaje);
    }
}
