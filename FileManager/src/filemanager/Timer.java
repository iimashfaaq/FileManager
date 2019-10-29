/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mercifulrookie
 */

public class Timer implements Runnable{
    
    Calendar cal;
    
    public Timer(Calendar c){
        cal = c;
    }
    
    @Override
    public void run() {
        while(true){
            cal.tick();
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(cal);
        }
        
    }
    
}