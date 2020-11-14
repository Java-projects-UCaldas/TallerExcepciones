import modelos.Vehiculo;

import javax.swing.JOptionPane;

import control.VehiculoException;;

public class App {
    public static void main(String[] args) throws Exception {

        Vehiculo carro = new Vehiculo("buenas", 3000);
        while(!carro.getAccidentado()){
            try {
                //carro.apagar();
                carro.encender();
                carro.acelerar(100);
                carro.acelerar(200);
                carro.detener(200);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
    }
}
