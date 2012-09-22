package real.action.thread;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class TimeDemo extends JPanel{
	JLabel clock;
	public TimeDemo(){
		this.setLayout(new BorderLayout());
		this.add(clock=new JLabel(),"East");
		this.setVisible(true);
		this.setOpaque(false);
		TimeThread tm=new TimeThread();
		tm.start();
	}
	class TimeThread extends Thread{
		public void run(){
			while(true){
				clock.setText(this.getTime());
				try{
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		public String getTime(){
			Calendar cal=new GregorianCalendar();
			String date=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);
			//将小于10的部分前面补0
			String hour=	cal.get(Calendar.HOUR_OF_DAY)>9	?	""+cal.get(Calendar.HOUR_OF_DAY)	:	"0"+cal.get(Calendar.HOUR_OF_DAY);
			String minute=	cal.get(Calendar.MINUTE)>9	?	""+cal.get(Calendar.MINUTE)	:	"0"+cal.get(Calendar.MINUTE);
			String second=	cal.get(Calendar.SECOND)>9	?	""+cal.get(Calendar.SECOND)	:	"0"+cal.get(Calendar.SECOND);
			String time=hour+":"+minute+":"+second;
			time=date+"    "+time+"   ";
			return time;
		}
	}

}