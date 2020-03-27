/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogo_3;

/**
 *
 * @author matti
 */
public class Dialogo_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InteractFile file = new InteractFile("copione.txt");
        
        Thread actor1 = new Thread(new Actor("actor1", file));
        Thread actor2 = new Thread(new Actor("actor2", file));
        
        actor1.start();        
        actor2.start();
        
    }
    
}
