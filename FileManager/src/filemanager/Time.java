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
public class Time {
    
    private int hour,min,sec;
    
    public Time(int h,int m,int s){
        this.hour = h;
        this.min = m;
        this.sec = s;
    }
    
    public boolean timeIncrement(){
        this.sec++;
        if(this.sec >= 60)
        {
            this.sec = 0;
            this.min++;
            if(this.min >= 60){
                this.min = 0;
                this.hour++;
                if(this.hour >= 24) {
                    this.hour = 1;
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return  (this.hour + ":" + this.min + ":" + this.sec);
    }
}

