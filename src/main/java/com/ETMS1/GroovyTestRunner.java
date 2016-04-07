package com.ETMS1;

import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by E on 30/03/2016.
 */
public class GroovyTestRunner implements Runnable{
    String fileName;
    GroovyTestRunner(String fileName){
        this.fileName = fileName;
    }

    //GroovyBrowserDaoETMS1 gbd2 = new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html");//werkte
    //gbd.RunProcessBuilder("F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\src\\test\\java\\com\\ETMS1\\TestCase01.groovy");
    //synchronized (fileName){
    //GroovyTestRunner gtr1 = new GroovyTestRunner(fileName);


    //Lock lock = new ReentrantLock();



    public void run(){
        GroovyBrowserDaoETMS1 gbd1 = new GroovyBrowserDaoETMS1(fileName);
        Thread t1 = new Thread(gbd1);
        t1.start();
        synchronized (fileName){
            try {
                System.out.println("beforeJoin");
                t1.join();
                //Thread.sleep(500);
                System.out.println("afterJoin");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ReportDao rep1 = new ReportDao();

            //rep1.readLog(new File(fileName));
            rep1.readLog(new File(fileName));
            System.out.println("rep1 created");
            GUI.longPropertyDatabaseChanged.setValue(System.currentTimeMillis());
        }
    }
}
