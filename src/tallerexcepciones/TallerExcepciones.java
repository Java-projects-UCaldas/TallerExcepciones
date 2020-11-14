/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerexcepciones;

import modelos.Vehiculo;

import javax.swing.JOptionPane;

import control.VehiculoException;

/**
 *
 * @author
 * @version 1.0
 */
public class TallerExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Vehiculo carro = new Vehiculo("buenas", 3000);
        while(!carro.getAccidentado()){
            try {
                //carro.apagar();
                carro.encender();
                carro.acelerar(100);
                carro.acelerar(200);
                carro.detener(200);
            } catch (VehiculoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}