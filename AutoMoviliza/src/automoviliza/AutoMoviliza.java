/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package automoviliza;

import Bd.Conexion;
import views.MenuPrincipal;

/**
 *
 * @author Cetecom
 */
public class AutoMoviliza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion cx = new Conexion();
        cx.conectar();
        
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        
    }
    
}
