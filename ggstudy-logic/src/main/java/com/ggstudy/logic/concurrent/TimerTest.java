package com.ggstudy.logic.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author xcj
 *定时，延时任务
 */
public class TimerTest {
	     
    public static void main(String[] args) {  
        Timer timer = new Timer();  
        timer.schedule(new MyTimerTask(), new Date(),1000);// 马上开始，每隔一秒一次
        timer.schedule(new MyTimerTask(), 1000);// 1秒后启动任务  
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        timer.cancel();
    }
    
    static class MyTimerTask extends TimerTask {  
        public void run() {  
            System.out.println("爆炸！！！");  
        }  
    }
}
