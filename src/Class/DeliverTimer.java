
package Class;

import javax.swing.SwingWorker;

/**
 * Class for the timer of the deliver
 * Date: 20/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public class DeliverTimer extends SwingWorker<String, String> {

    String time;
    int seconds;
    boolean ready;

    public DeliverTimer(String time) {
        this.time = time;
        this.ready=false;
    }
    
    /**
     * Timer in the background
     * @return
     * @throws Exception 
     */
    @Override
    protected String doInBackground() throws Exception {
        while(true){
            String[] time3 =this.time.split(":");
            int hour= Integer.parseInt(time3[0]);
            int min=Integer.parseInt(time3[1]);
            Thread.sleep(1000);
            if (seconds==60) {
                min++;
                seconds=0;
            }
            seconds++;
            if (ready) {
                break;
            }
            if (min==60) {
                hour+=1;
                min=0;
            }
            if (min<10&&hour<10) {
                this.time="0"+hour+":0"+min;
            }
            else if (min<10) {
                this.time=hour+":0"+min;
            }
            else if(hour<10){
                this.time="0"+hour+":"+min;
            }
            else{
            this.time=hour+":"+min;
            }            
        }
        return time;
    }
    
    /**
     * Method to stop the timer
     */
    public void finish(){
        this.ready=true;
    }
}
