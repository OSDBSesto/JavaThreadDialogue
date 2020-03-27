/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogo_3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matti
 */
public class Dialogo_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InteractFile file = new InteractFile("file.txt");
        
        Thread actor1 = new Thread(new Actor("actor1", file));
        Thread actor2 = new Thread(new Actor("actor2", file));
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Dialogo_3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        actor1.start();        
        actor2.start();
        
    }
    
}
