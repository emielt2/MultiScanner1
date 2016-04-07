package com.ETMS1;

import geb.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by E on 24/03/2016.
 */
public class SelTest implements Runnable {
    String urlString;
    String driverChoice;
    WebDriver webDriver;
    static Browser browser;
    public static WebDriver driver;//was driver
    static String baseUrl; //idee voor global
    public SelTest(String urlString, WebDriver webDriver){
        this.urlString=urlString;
        //this.webDriver = webDriver;
    }
    public void TestCCC(){
        System.out.println("CCC");
    }
    public void TestSelenium(){
        //WebDriver wd = new ChromeDriver();
        //wd1.get("http://www.cnn.com");
        webDriver = new ChromeDriver();
        ChromeOptions chromeoptions = new ChromeOptions();
        //chromeoptions.addArguments("start-maximized");
        //chromeoptions.addArguments("user-data-dir=/path/to/your/custom/profile");
        chromeoptions.addArguments("user-data-dir=Y:\\Browser_profileManual");
        //HIER browser = new Browser(driver: new ChromeDriver(chromeoptions), baseUrl: urlString);//(new ChromeDriver());
        //browser = new Browser(driver:webDriver) ;//(new ChromeDriver());
        System.out.println("opening!");
        webDriver.get(urlString);
        try {
            System.out.println("sleeping!");
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("closing!");
        browser.close();
        //webDriver.close();
        //webDriver.quit();
    }




    @Override
    public void run() {
        while(true){
            TestSelenium();
        }

    }
}
