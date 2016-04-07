package com.ETMS1

import geb.spock.GebReportingSpec
import junit.textui.TestRunner
import org.junit.rules.TestWatcher
import org.openqa.selenium.WebDriver
import spock.lang.Stepwise
import com.ETMS1.GebConfigExtraETS2.*;
import com.ETMS1.GroovyBrowserDaoETMS1;
import geb.transform.AttributeAccessingMetaClassRegistrar;

//import org.gebish.geb-ast;
//import geb.transform.implicitassertions.Runtime;
//import geb.spock.GebReportingSpec
//import spock.lang.Stepwise

/**
 * Created by E on 27/03/2016.
 */

@Stepwise
class ProcTestCase01 extends GebReportingSpec {

    def "Step 01 Go To local"() {
        when: "Go To local111"
        println "Go To local111"
        //to GooglePage
        to Random1Page

        ClickTimes(1,1100)
        then: "local111 is opened"
        println "local111 is opened"
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
     def "Step 03 Go To local222"() {
         when: "Go To local222"
         //println "Go To local"
         //to GooglePage
         to Random2Page

         //ClickTimes(1,1000)
         then: "local222 is opened"
         //println "local is opened"
         //at GooglePage
         at Random2Page

     }

    def setupSpec() {
        println "setupSpec 4Ax"

        //GebConfigExtraETS2 gce = new GebConfigExtraETS2();
        int number;
        number = new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html").getNewBrowserNumber();
        //GUI x1=new GUI();
        System.out.println("hello");
        new GUI().getProperties();
        //int xx = new GUI().getNewBrowserNumber();
        //System.out.println(xx);
        println " getNewBrowserNumber gave = " + number;
        browser.driver = new GebConfigExtraETS2().getDriver("chrome", "nl",number)

    }
    def cleanupSpec() {
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
        browser.quit()
        println "This is after quit() and before exit"
        //System.exit(0)
        //System.exit(3);
        println "This is after exit()"

        //browser.report()
        //System.exit(-10)
        return
    }

}



/*
class TestCase01 {}*/