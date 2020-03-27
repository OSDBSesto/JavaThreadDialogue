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
public class Actor implements Runnable {

    private String actorName;
    private InteractFile file;
    private int linesCont;

    public Actor(String actorName, InteractFile file) {
        this.actorName = actorName;
        this.file = file;
        linesCont = file.getLinesCont()/2;
        //System.out.println(actorName + " lines: " + linesCont);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < linesCont; i++) {
                //System.out.println(actorName + " -> line: " + i + " dialogue actor: " + file.getActor());
                if (file.getActor().equals(actorName)) {
                    System.out.println(actorName + ": " + file.getDialogue());
                    int pause = file.getPause()/2;
                    Thread.sleep(pause);
                    file.continueReading();
                    Thread.sleep(pause);
                } else{
                    Thread.sleep(file.getPause());
                }
            }
        } catch (InterruptedException ex) {
            System.out.println("error in run");
        }
    }

}
