
package Class;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author gusta
 */
public class Timer extends SwingWorker<String, String> {

    String time;
    String time2;
    Food food;

    public Timer(String time, String time2, Food food) {
        this.time = time;
        this.time2 = time2;
        this.food=food;
    }
    
    @Override
    protected String doInBackground() throws Exception {
        while(this.time2!=this.time){
            String[] time3 =this.time.split(":");
            int hour= Integer.parseInt(time3[0]);
            int min=Integer.parseInt(time3[1]);
            Thread.sleep(60000);
            if (min==60) {
                hour+=1;
                min=0;
            }
            min+=1;
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
            if (time.equals(time2)&&time!=null &&time2!=null) {
                break;
            }
        }
        int price= food.getTempPrice();
        food.setPrice(price);
        JOptionPane.showMessageDialog(null, "The discount for "+ food.getName()+ " ended");
        return time;
    }
    
}
