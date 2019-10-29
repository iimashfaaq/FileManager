/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

/**
 *
 * @author mercifulrookie
 */
public class Calendar{
    
    private Date date;
    private Time time;
    
    public Calendar(Date dt,Time t){
        this.date = dt;
        this.time = t;
    }
    
    public void tick(){
        if(time.timeIncrement())
            date.dateIncrement();
    }
    
    public Date getDate() {
        return this.date;
    }
    
    @Override
    public String toString(){
        return ("Date: "+date+"Time: "+time);
    }
    
}