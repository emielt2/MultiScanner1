package com.ETMS1

import DAO_PACKAGE.SQLiteJDBC_DAO
import geb.spock.GebReportingSpec
import org.openqa.selenium.WebDriver
import spock.lang.Shared
import spock.lang.Stepwise

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

//import org.gebish.geb-ast;
//import geb.transform.implicitassertions.Runtime;
//import geb.spock.GebReportingSpec
//import spock.lang.Stepwise

/**
 * Created by E on 27/03/2016.
 */

@Stepwise
class ProcTestCase01xx extends GebReportingSpec {

    def "Step 01 Go To local"() {
        when: "Go To localxx1"
        println "Go To localxx1"
        //to GooglePage
        to Random1Page
        int range=10
        int randomx = (int)((Math.random()*range))+10
        label1text.value("NUMBER = "+number + "   randomx="+randomx)

        ClickTimes(randomx,300)

        then: "local is opened"
        //assert randomx>15
        println "local is opened"
        //at GooglePage
        at Random1Page

    }

    /*
    def "Step 02 Go To Google"() {
        when:
        to GooglePage
        sleep(1500)
        then:
        at GooglePage //CHANGED ON PURPOSE
        //at GettyPage
    }
*/
     def "Step 03 Go To local"() {
         when: "Go To local"
         //println "Go To local"
         //to GooglePage
         to Random2Page

         //ClickTimes(1,1000)
         then: "local is opened"
         //println "local is opened"
         //at GooglePage
         at Random2Page

     }
    @Shared
    private int number;

    @Shared
    ReentrantLock extralock = new ReentrantLock();
    def setupSpec() {
        println ("setupSpec: Class is: "+getClass())
        println ("setupSpec: StartTime is: "+Calendar.getInstance().timeInMillis);
        //GebConfigExtraETS2 gce = new GebConfigExtraETS2();
        number=-1;
        System.out.println("hello");
        //sleep(1000)
        //number = new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html").getNewBrowserNumber();
        //GUI x1=new GUI();
        //sleep(1000)
        //number = new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html").getNewBrowserNumber();
        //sleep(1000)
        //number = new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html").getNewBrowserNumber();
        //number = GroovyBrowserDaoETMS1.getNewBrowserNumber();//?????????? WERKT DIT? //TODO CHECK
        //System.out.println(number);
        //number=new GUI().getNewBrowserNumber();//todo WHYYYYYY gaat dit fout terwijl het bij scanner2 wel mag (class extends application is the fault). kwam door Application missing als CLASSPATH
        //GUI guix = new GUI();
        //int booleanArray = guix.activeBrowsers[number]=true;
        //boolean[] activeBrowserscopy=guix.activeBrowsers;
        //activeBrowserscopy[number]=true;
        //System.out.println()
        //guix.activeBrowsers[number]=true;
        //guix.activeBrowsers=activeBrowserscopy;
        //extralock.lock()
        //GUI.GUIlockobject.lock()
        synchronized (SQLiteJDBC_DAO.lockobject){
        while(number==-1) {
            //GroovyBrowserDaoETMS1.GroovyBrowserDaoETMS1lockobject.lock()
            //SQLiteJDBC_DAO.lockobject.lock()

            //SQLiteJDBC_DAO.lockobject.wait()

           // sleep(500)
                //  number = new SQLiteJDBC_DAO().findFree();
                    number = new SQLiteJDBC_DAO().takeFreeBrowser("TestCase x123")//getClass
                println "NUMBER====================================="+number
            if(number==-1){sleep(500)}
            //new SQLiteJDBC_DAO().takeBrowser(number, "TestCase x123", "TAKEN");

            }
            //SQLiteJDBC_DAO.lockobject.unlock()
            //SQLiteJDBC_DAO.lockobject.notify()
        }
       //extralock.unlock()
        //GUI.GUIlockobject.unlock()
        //GroovyBrowserDaoETMS1.GroovyBrowserDaoETMS1lockobject.unlock()//TODO UNLOCK

        try{
            //Thread.sleep(10000)
        }
        catch (Exception e1){}

        //println(new GUItryout().number);



        //int xx = new GUI().getNewBrowserNumber();
        //System.out.println(xx);
        println " getNewBrowserNumber gave = " + number;
        GroovyBrowserDaoETMS1.ShellToFixRestoreChrome(new File("Y:/Browser_profile"+number+"/Default/Preferences"),number);
        //Thread.sleep(1000)
        browser.driver = new GebConfigExtraETS2().getDriver("chrome", "nl",number)

    }
    def cleanupSpec() {
        println ("cleanupSpec: EndTime is: "+Calendar.getInstance().timeInMillis);
        driver.get("about:blank")
        GroovyBrowserDaoETMS1.storeDriver(driver);
        GebConfigExtraETS2 gcf = new GebConfigExtraETS2();
        gcf.extraDriver=driver;
        println "driver info1 =" + driver.getTitle()
        WebDriver driver = new GroovyBrowserDaoETMS1().giveDriver()
        println "driver info2 =" + driver.getTitle()
        /*for(int i=0;i<10;i++){
            for(int j=0;j<5;j++){
                print " ################ "
            }
            print " ################ ---\n---"
        }*/
        //browser.report
        //getBrowser().reportGroupDir
        //TestWatcher tw = new TestWatcher();
        //browser.driver.close()
        //System.finalize();

        //browser.close()
        //TestRunner.
        //browser.close()

        //browser.close()
        //driver.close()
        //driver.close()
        browser.close()
        driver.quit()

        browser.quit()//DEZE MELDT GOED AF ALS THREAD MAAR RESTORE-SESSION CHROME NEXT TIME (driver.quit en browser.quit samen werkt, maar niet zeker 100%
        //driver.close()
        //browser.close()

        println "This is after quit() and before exit"
        //System.exit(0)
        //System.exit(3);
        println "This is after exit()"
        //sleep(1000)
        SQLiteJDBC_DAO.giveback(number,"NULL","FREE");
        //SQLiteJDBC_DAO.giveback(2,"NULL","FREE");
        //browser.report()
        //System.exit(-10)
        return
    }

}



/*
class TestCase01 {}*/