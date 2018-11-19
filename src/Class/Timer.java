
package Class;

import javax.swing.SwingWorker;

/**
 *
 * @author gusta
 */
public class Timer extends SwingWorker<String, String> {

    String time;
    String time2;

    public Timer(String time, String time2) {
        this.time = time;
        this.time2 = time2;
    }
    
    @Override
    protected String doInBackground() throws Exception {
        while(time!=time2){
            String[] time3 =time.split(":");
            int hour= Integer.parseInt(time3[0]);
            int min=Integer.parseInt(time3[1]);
            Thread.sleep(60000);
            if (min==60) {
                hour+=1;
                min=0;
            }
            min+=1;
            if (min<10&&hour<10) {
                time="0"+hour+":0"+min;
            }
            else if (min<10) {
                time=hour+":0"+min;
            }
            else if(hour<10){
                time="0"+hour+":"+min;
            }
            else{
            time=hour+":"+min;
            }
            System.out.println(time);
        }
        return time;
    }
    
}
