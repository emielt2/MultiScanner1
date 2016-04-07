

package com.ETMS1

import geb.Browser
import geb.report.PageSourceReporter;
/*WAS import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.fail;
*/
import geb.report.ReportState
import geb.report.ScreenshotReporter
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.interactions.Actions

import java.util.concurrent.TimeUnit

//import org.openga.selenium.


/**
 * Created by E on 17/01/2016.
 */


/**kan misschien weg?*/
public class ShellRunner implements Runnable{
    public ShellRunner(String input,int number){
        baseUrl = input;
        this.number = number;
    }


    static String baseUrl; //idee voor global
    public static WebDriver driver;//was driver
    public static String shellReturnString01
    public static String shellReturnString02
    private boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();
    static Browser browser2;
    int number;
/*
    public static void startSeleniumConnection(String inputUrl) throws Exception {
        System.out.println("Check1 " + baseUrl);
        System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDownloadFolder\\chromedriver_win32\\chromedriver.exe");//todo setproperty bekijken
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("user-data-dir=Y:\\Browser_profileManual" + number);
        browser2 = new Browser(driver: new ChromeDriver(chromeoptions), baseUrl: inputUrl)//(new ChromeDriver());
        browser2.go()
        System.out.println("Check3");
    }
    public static void stopSeleniumConnection() throws Exception {
        browser2.close()
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }
*/
    String RunGroovyShellMulti(String string1x) {
        String returnvalue = "startvalue returnvalue";
        GroovyShell shell = new GroovyShell();
        System.out.println("Check x01");
        shell.run(new File(string1x));//WORKS!!
        String x = new File(string1x).toString();
        returnvalue =x;
        return returnvalue
    }

    @Override
    void run() {
        //String url = "F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\src\\main\\java\\com\\ETMS1\\TestCase0" + number + ".groovy";
        String url = "F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\src\\test\\java\\com\\ETMS1\\TestCase0" + number + ".groovy";
        //String url = "F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\src\\main\\java\\com\\ETMS1\\TestCase0" + 1 + ".groovy";
        System.out.println("url is " + url)

        RunGroovyShellMulti(url);
    }
}
