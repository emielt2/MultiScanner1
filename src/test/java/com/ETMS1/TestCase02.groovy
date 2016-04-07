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
class TestCase02 extends GebReportingSpec {

    def "Step 01 Go To local"() {
        when: "Go To local"
        println "Go To local"
        to Random2Page

        ClickTimes(4,2000)

        then: "local is opened"
        println "local is opened"
        at Random2Page

    }

    def "Step 01 Go To Getty"() {
        when:
        to GettyPage
        sleep(1500)
        then:
        at GettyPage
    }

    def "Step 03 Go To local"() {
        when: "Go To local"
        println "Go To local"
        //to GooglePage
        to Random1Page

        ClickTimes(4,2000)

        then: "local is opened"
        println "local is opened"
        //at GooglePage
        at Random1Page

    }

    def setupSpec() {
        println "setupSpec 4Ax"

        GebConfigExtraETS2 gce = new GebConfigExtraETS2();
        int number;
        number = new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html").getNewBrowserNumber();
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
        browser.driver.close()
        return
    }

}



/*
class TestCase01 {}*/