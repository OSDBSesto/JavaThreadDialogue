/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogo_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matti
 */
public final class InteractFile {

    private BufferedReader reader;
    private String stringDialogue;
    private String stringPause;
    private int lines;

    InteractFile(String fileName) {
        try {
            reader = new BufferedReader(new FileReader(fileName));
            lines = linesCont();
            reader.close();
            reader = new BufferedReader(new FileReader(fileName));
            continueReading();
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        } catch (IOException ex) {
            System.out.println("IOExc on close or init");
        }
    }

    private int linesCont() {
        String s;
        int i = 1;
        try {
            s = reader.readLine();
            while (s != null) {
                s = reader.readLine();
                i++;
            }

        } catch (IOException ex) {
            System.out.println("IOExc in lines cont");
        }
        //System.out.println("line count catch: " + i);
        return i-1;
    }

    public String getDialogue() {
        return stringDialogue.substring(4, stringDialogue.length() - 1);
    }

    public String getActor() {
        if (stringDialogue.substring(0,2).equals("t1")) {
            return "actor1";
        } else if (stringDialogue.substring(0,2).equals("t2")) {
            return "actor2";
        }
        return "ciaone";
    }

    public int getPause() {
        try {
            return Integer.parseInt(stringPause);
        } catch (NumberFormatException e) {
            System.out.println("Pause string not valid");
            return 0;
        }
    }

    public synchronized void continueReading() {
        try {
            stringDialogue = reader.readLine();
            stringPause = reader.readLine();
        } catch (IOException ex) {
            System.out.println("Error while reading file");
        }
    }
    
    public int getLinesCont(){
        return lines;
    }

}
