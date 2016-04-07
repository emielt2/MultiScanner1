package com.ETMS1;

import geb.Browser
//import geb.spock.GebReportingSpec
import org.openqa.selenium.By
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.firefox.internal.ProfilesIni
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by E on 24/03/2016.
 */
public class SelTestGroovy implements Runnable {
    String urlString;
    String driverChoice;
    WebDriver webDriver;
    Browser browser;

    public WebDriver driver;//was driver
    String baseUrl; //idee voor global
    int number;
    public SelTestGroovy(String urlString, String driverChoice, int number){
        this.urlString=urlString;
        this.driverChoice = driverChoice;
        this.number = number;

    }
    public void TestCCC(){
        System.out.println("CCC");
    }

    boolean running = false;
    public void TestSelenium(){
        //WebDriver wd = new ChromeDriver();
        //wd1.get("http://www.cnn.com");

        if(driverChoice.equals("chrome") & running==false){
//        webDriver = new ChromeDriver();
            ChromeOptions chromeoptions = new ChromeOptions();
            //chromeoptions.addArguments("start-maximized");
            //chromeoptions.addArguments("user-data-dir=/path/to/your/custom/profile");
            chromeoptions.addArguments("user-data-dir=Y:\\Browser_profile"+number);
            browser = new Browser(driver: new ChromeDriver(chromeoptions), baseUrl: urlString);//(new ChromeDriver());
            //browser = new Browser(driver:webDriver) ;//(new ChromeDriver());
            System.out.println("opening on thread"+number);
            //webDriver.get(urlString);
            browser.go();
            try {
                System.out.println("sleeping on thread" +number);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("closing on thread"+number);
            //browser.close();
            //browser.quit();
            running=true;
        }
        if(driverChoice.equals("firefox")){

            DesiredCapabilities desiredCapabilities =
                    new DesiredCapabilities("firefox", "", Platform.ANY);
            FirefoxProfile profile = new ProfilesIni().getProfile("webdriver1");
            desiredCapabilities.setCapability("firefox_profile", profile);
            //WebDriver webdriver = new RemoteWebDriver(desiredCapabilities);




            String profiledir = "Y:\\Browser_profile" + number;
            FirefoxProfile fp = new FirefoxProfile(new File(profiledir));

            //-----
            //ProfilesIni profileini = new ProfilesIni();

            //FirefoxProfile profile = new FirefoxProfile(new File("D:\\Selenium Profile"));


            //FirefoxProfile ffprofile = profileini.getProfile("SELENIUMx");
            //WebDriver driver = new FirefoxDriver(ffprofile);
            //------

            //fp.properties.println();
            //System.out.println(fp.getProperties());
            //Firefo
            //WebDriver x = new FirefoxDriver();
            //chromeoptions.addArguments("user-data-dir=Y:\\Browser_profile"+number);
            //browser = new Browser(driver: new FirefoxDriver(fp), baseUrl: urlString);//(new ChromeDriver());
            browser = new Browser(driver: new FirefoxDriver(fp), baseUrl: urlString);//(new ChromeDriver());
            System.out.println("opening on thread"+number);
            browser.go();
            try {
                System.out.println("sleeping on thread" +number);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("closing on thread"+number);
            browser.close();
        }

        if(driverChoice.equals("ie")){


            //-----
            //ProfilesIni profileini = new ProfilesIni();

            //FirefoxProfile profile = new FirefoxProfile(new File("D:\\Selenium Profile"));


            //FirefoxProfile ffprofile = profileini.getProfile("SELENIUMx");
            //WebDriver driver = new FirefoxDriver(ffprofile);
            //------

            //fp.properties.println();
            //System.out.println(fp.getProperties());
            //Firefo
            //WebDriver x = new FirefoxDriver();
            //chromeoptions.addArguments("user-data-dir=Y:\\Browser_profile"+number);
            //browser = new Browser(driver: new FirefoxDriver(fp), baseUrl: urlString);//(new ChromeDriver());
            DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
            System.out.println(capabilitiesIE.getProperties());

            browser = new Browser(driver: new InternetExplorerDriver(), baseUrl: urlString);//(new ChromeDriver());
            System.out.println("opening on thread"+number);
            browser.go();
            try {
                System.out.println("sleeping on thread" +number);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("closing on thread"+number);
            browser.close();
            //browser2.getDriver().findElement(new By.ByCssSelector(stringcss1)).getAttribute(stringcss2);
            //driver.findElement(new By.ByCssSelector("linkText")).getAttribute("testing");
            //driver.findElement(By.cssSelector(cssstring1)).click();

            //driver.find(By new By("body","abc"));
        }


        browser.find(By.cssSelector("body.input")).click();
        browser.find(By.id("FFid")).click();
        try {
            System.out.println("sleeping on thread" +number);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //browser.quit();
    }




    @Override
    public void run() {
        while(true){
            TestSelenium();
        }

    }
}
