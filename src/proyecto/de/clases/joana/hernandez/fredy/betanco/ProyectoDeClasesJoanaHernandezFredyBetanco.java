/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.de.clases.joana.hernandez.fredy.betanco;
import java.util.Scanner;
/**
 *
 * @author joana
 */
public class ProyectoDeClasesJoanaHernandezFredyBetanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        char resp;
        do {
            System.out.println("Bienvenido/a al banco en linea oficial de UNITEC");
            System.out.println("Presione x para salir del sitio");
            System.out.println("Tiene cuenta existente? s/n");
            resp = sc.next().charAt(0);
            
            switch (resp) {
                case 's', 'S':
                    
                    break;
                case 'n','N':
                    
                    break;
            }
            
        } while (resp != 'x');
        System.out.println();
        if (resp == 'x') {
            System.out.println("Feliz dia");
        }
    }
    
}
