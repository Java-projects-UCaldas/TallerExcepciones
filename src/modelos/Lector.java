package modelos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLabel;

/**
 * Clase que lee el archivo de texto con la información
 * para la creación del Vehículo
 * @author 
 * @version 1.0
 */
public class Lector {

    private String rutaCarpeta;

    public Lector(String rutaCarpeta){
        this.rutaCarpeta = rutaCarpeta;
    }

    /**
     * Método que devuevle un Vehiculo
     * @return  Un objeto de la clase Vehiculo
     * @throws IOException
     */
    public Vehiculo CreaVehículo() throws IOException{

        File archivo = new File(this.rutaCarpeta);
        List<String> datos = new ArrayList<>();
        String[] palabras = null; 
            if (archivo.isFile() && archivo.getName().contains("txt")) {
                    File archivoAleer = new File(archivo.getAbsolutePath());  
                    FileReader lectorArchivo = new FileReader(archivoAleer);  
                    BufferedReader bufferDeLectura = new BufferedReader(lectorArchivo); 
                    String linea;  
                    while((linea = bufferDeLectura.readLine()) != null)  
                    {
                        palabras = linea.split("[!?.:,()\"\\s]+");  
                        for (String palabra : palabras) 
                        {
                            datos.add(palabra);
                        }
                    }
                    lectorArchivo.close();
                }
                else{
                    datos.add("El archivo no es del tipo txt");
                }
            
        Vehiculo nuevoVehiculo = new Vehiculo(datos.get(1), Integer.parseInt(datos.get(3)));
       return nuevoVehiculo;
    }
}