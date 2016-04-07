package com.ETMS1

import geb.spock.GebReportingSpec
import org.openqa.selenium.WebDriver
import spock.lang.Stepwise

//import geb.spock.GebReportingSpec
//import spock.lang.Stepwise

/**
 * Created by E on 27/03/2016.
 */

@Stepwise
class TestCase04 extends GebReportingSpec {
   /* def "This is the first test step"() {
        when:
        to GooglePage
        println("When")
        then:
        at GooglePage
        println("Then")
    }*/

    def "Step 01 Go To local"() {
        when: "Go To local"
        println "Go To local"
        //to GooglePage
        to Random1Page

        ClickTimes(10,2000)
        then: "local is opened"
        println "local is opened"
        //at GooglePage
        at Random1Page

    }

    def setupSpec() {
        println "setupSpec 4Ax"

        GebConfigExtraETS2 gce = new GebConfigExtraETS2();
        int number;
        //int number = gce.getNumber();
        //int number = new GroovyBrowserDaoETMS1().numberOfActiveBrowsers++;
        //number = new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html").numberOfActiveBrowsers++;
        number = new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html").getNewBrowserNumber();

        //int number = new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html").getNumberOfActiveBrowsers();

        println " getNewBrowserNumber gave = " + number;
        //new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html").setnumberOfActiveBrowsers(number);
        //new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html").number;
        browser.driver = new GebConfigExtraETS2().getDriver("chrome", "nl",number)

    }
    def cleanupSpec() {
        //GroovyBrowserDaoETMS1.storeDriver( driver);
        //GroovyBrowserDaoETMS1 gbd = new GroovyBrowserDaoETMS1()
        //gbd.storeDriver( driver);
        GroovyBrowserDaoETMS1.storeDriver(driver);
        //new ETS2_GUI().storedWebDriver = driver;
        //gebconfDriver = driver;
        GebConfigExtraETS2 gcf = new GebConfigExtraETS2();
        gcf.extraDriver=driver;
        println "driver info1 =" + driver.getTitle()
        //sleep(500)
        WebDriver driver = new GroovyBrowserDaoETMS1().giveDriver()
        println "driver info2 =" + driver.getTitle()
        //sleep(1000)

        //System.exit(0)
        browser.driver.close()
        return
    }

}



/*
class TestCase01 {}*/