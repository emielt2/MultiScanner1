

package com.ETMS1

import geb.Browser;
/*WAS import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.fail;
*/
import geb.report.PageSourceReporter
import geb.report.ReportState
import geb.report.ScreenshotReporter
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.interactions.Actions
import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl

import java.nio.file.Files
import java.nio.file.Paths
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

//import org.openga.selenium.


/**
 * Created by E on 17/01/2016.
 */


/**kan misschien weg?*/
public class GroovyBrowserDaoETMS1 implements Runnable{
    public GroovyBrowserDaoETMS1(String input){
        baseUrl = input;
        fileName = input;
    }

    static public Lock GroovyBrowserDaoETMS1lockobject = new ReentrantLock();
    static String baseUrl; //idee voor global
    public static WebDriver driver;//was driver
    public static String shellReturnString01
    public static String shellReturnString02
    private boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();
    static Browser browser2;
    static int numberOfActiveBrowsers=0;
    String fileName;

    final static int totalAmountBrowserprofiles=10;
    //static int[] availableBrowsers= new Integer()[totalAmountBrowserprofiles];

    public static void startSeleniumConnection(String inputUrl) throws Exception {
        System.out.println("Check1 " + baseUrl);
        System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDownloadFolder\\chromedriver_win32\\chromedriver.exe");//todo setproperty bekijken
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("user-data-dir=Y:\\Browser_profileManual");
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

    public boolean trigIsSelected() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try{
            if(driver.findElement(By.id("menu")).isDisplayed())return true;
            if(driver.findElement(By.id("menu")).getText()!="Statistics")return false;
        }
        catch(Exception e){
            System.out.println("#menu not found");
            // e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getSelectorText(String stringcss1, String stringcss2) {
        try {
            String returnvalue = "startvaluex"
            browser2.drive{
                try {
                    println "HIER1"
                    returnvalue = browser2.getDriver().findElement(new By.ByCssSelector(stringcss1)).getAttribute(stringcss2);
                    print browser2.getDriver().findElement(new By.ByCssSelector(stringcss1)).getAttribute(stringcss2);
                    println "HIER2"
                }
                catch (Exception e){
                    println "HIER3"
                    returnvalue = e.message.toString();
                }
            }
            println "HIER4"
            return returnvalue
        }
        catch(NoSuchElementException e){
            println "Exception not found"
            return e.message.toString();
        }
    }

    public static String getThis(String stringcss1, String stringcss2) {
        String returnvalue
        browser2.drive{
            try{
                returnvalue = browser2.$(stringcss1).getProperties()
            }
            catch (Exception e){
                return e.message.toString();
            }
        }
        return returnvalue
    }

    String[] doGebSpockActionOnShell(String elementString, String bystring, String stringstring, String actionstring, String contentNameString, String choiceBrowser) {

        String[] returnvalue = ["Error!", "Error!", "Error!", "Error!"]



        if(choiceBrowser=="Shell") { //driver.findElement(By.cssSelector(cssstring1)).click();
            try {
                println "StartX"
                String scriptBegin;
                String scriptMid;
                String scriptEnd;
                if (elementString == "") {
                    println "ja"
                    scriptBegin = new String("import ETS2.GroovyBrowserDaoETMS1;import org.openqa.selenium.By;public class test{public static void main(String...args){GroovyBrowserDaoETMS1 gb = new GroovyBrowserDaoETMS1();gb.shellReturnString01 = gb.driver.");
                    scriptMid = new String("findElement(By." + bystring + "(\"" + stringstring + "\"))." + actionstring + ".toString();System.out.println(gb.shellReturnString01);");
                    scriptEnd = new String("}}");
                } else {//make:  overlayToevoegenNotitieAnoniem { $("div", id: contains("SUB008_1"))}
                    println "nee"
                    scriptBegin = new String("import ETS2.GroovyBrowserDaoETMS1;import org.openqa.selenium.By;public class test{public static void main(String...args){GroovyBrowserDaoETMS1 gb = new GroovyBrowserDaoETMS1();gb.shellReturnString01 = gb.driver.");
                    scriptMid = new String("findElement(By." + bystring + "(\"" + stringstring + "\"))." + actionstring + ".toString();System.out.println(gb.shellReturnString01);");
                    scriptEnd = new String("}}");
                }
                String scriptTotal = scriptBegin + scriptMid + scriptEnd;
                returnvalue[0] = scriptMid //real scrtiptmid, is real code
                returnvalue[1] = scriptMid //india style
                returnvalue[2] = shellReturnString01 //voor scenetitle2
                returnvalue[3] = "hallo" //voor scenetitle2
                println "shellReturnString01====" + shellReturnString01
                println scriptTotal
                Binding binding = new Binding();
                GroovyShell shell = new GroovyShell(binding);
                Object value = shell.evaluate(scriptTotal);
            }
            catch (Exception e) {
                returnvalue[2] = e.message.toString();
                return returnvalue

            }
        }

        if(choiceBrowser=="Manual") { //driver.findElement(By.cssSelector(cssstring1)).click();
            try {
                println "StartManual"
                String scriptBegin;
                String scriptMid;
                String scriptEnd;
                if (elementString == "") {
                    println "ja"
                    scriptBegin = new String("import ETS2.GroovyBrowserDaoETMS1;import org.openqa.selenium.By;public class test{public static void main(String...args){GroovyBrowserDaoETMS1 gb = new GroovyBrowserDaoETMS1();gb.shellReturnString01 = gb.browser2.getDriver().");
                    scriptMid = new String("findElement(By." + bystring + "(\"" + stringstring + "\"))." + actionstring + ".toString();System.out.println(gb.shellReturnString01);");
                    scriptEnd = new String("}}");
                } else {//make:  overlayToevoegenNotitieAnoniem { $("div", id: contains("SUB008_1"))}
                    println "nee"
                    scriptBegin = new String("import ETS2.GroovyBrowserDaoETMS1;import org.openqa.selenium.By;public class test{public static void main(String...args){GroovyBrowserDaoETMS1 gb = new GroovyBrowserDaoETMS1();gb.shellReturnString01 = gb.browser2.getDriver().");
                    scriptMid = new String("findElement(By." + bystring + "(\"" + stringstring + "\"))." + actionstring + ".toString();System.out.println(gb.shellReturnString01);");
                    scriptEnd = new String("}}");
                }
                String scriptTotal = scriptBegin + scriptMid + scriptEnd;
                returnvalue[0] = scriptMid //real scrtiptmid, is real code
                returnvalue[1] = scriptMid //india style
                returnvalue[2] = shellReturnString01 //voor scenetitle2
                returnvalue[3] = "hallo" //voor scenetitle2
                println "shellReturnString01====" + shellReturnString01
                println scriptTotal
                Binding binding = new Binding();
                GroovyShell shell = new GroovyShell(binding);
                Object value = shell.evaluate(scriptTotal);
            }
            catch (Exception e) {
                returnvalue[2] = e.message.toString();
                return returnvalue

            }
        }



            returnvalue[2]=GroovyBrowserDaoETMS1.shellReturnString01;
        return returnvalue

    }




    String doGebSpockAction(String bystring, String stringstring, String actionstring) {

        String returnvalue = "returnvalue not changed something went wrong"

        browser2.drive{
        //driver.navigate()??{

            if(actionstring=="click()"){
               // browser2.getDriver().findElement(By.id(stringstring)).click();
                //browser2.getDriver().findElement(By.cssSelector(stringstring)).click();
               // GroovyBrowserDaoETMS1.browser2.getDriver().findElement(By.cssSelector(stringstring)).click();
                //findElement(By.cssSelector(stringstring)).click();
                //returnvalue="browser2.getDriver().findElement(By.cssSelector("+stringstring+")).click();"//werkt niet want geen browser2 zichtbaar
                //returnvalue= new String("Label1:{GroovyBrowserDaoETMS1.browser2.getDriver().findElement(By.cssSelector("+stringstring+")).click();}")
                returnvalue= new String("import ETS2.GroovyBrowserDaoETMS1;import org.openqa.selenium.By;public class test{public static void main(String...args){new GroovyBrowserDaoETMS1().browser2.getDriver().findElement(By.cssSelector(\""+stringstring+"\")).click();}}")
                println returnvalue
                //returnvalue= new String("browser2.getDriver().findElement(By.cssSelector("+stringstring+")).click();")


              //  StringBuilder eval = new StringBuilder("");
              //  eval.append("Label1:")
             //   println "Eval = " + eval
//                returnvalue="println \"Hello22222\"";

                Binding binding = new Binding();
                GroovyShell shell = new GroovyShell(binding);
                int y = 0;
                print "yyy = " + y
                //Object value1 = shell.evaluate("for (x=0; x<5; x++){println \"Hello\";y++}; return x"); //prints 5 times hello
                print "yyy = " + y
                Object value = shell.evaluate(returnvalue);
                //todo medewerkers-it heeft oa  static content { overlayAanmakenNieuweZaak { $("div", id: contains("ZKN004_1"))} }
            }

        }
        return returnvalue

    }

    public String getSelectorX(String stringcss) {
        try {
            return driver.findElement(new By.ByCssSelector(stringcss)).getTagName();

            //return driver.findElement(new By.ByCssSelector(stringcss)).getText();
        }
        catch(NoSuchElementException e){
            e.printStackTrace();
            return "NOT FOUND";
        }
    }
    public void printAllSelectorX(String stringcss1, String stringcss2) {
        System.out.println("stringcss1=    " + stringcss1);
        System.out.println("stringcss2=    " + stringcss2);
        try {
            System.out.println(
                    "getTagName() gives: " +
                            driver.findElement(new By.ByCssSelector(stringcss1)).getTagName()
                    //browser1.findElement(new By.ByCssSelector(stringcss1)).getTagName()
            );
            System.out.println(
                    "getText() gives: " +
                            //driver.findElement(new By.ByCssSelector(stringcss)).getAttribute()
                            driver.findElement(new By.ByCssSelector(stringcss1)).getText()
            );
            System.out.println(
                    "getAtrribute(\"class\") gives: " +
                            //todo attribute uit nieuw tekstveld;
                            //driver.findElement(new By.ByCssSelector(stringcss)).getAttribute()
                            driver.findElement(new By.ByCssSelector(stringcss1)).getAttribute(stringcss2)
            );

        }
        catch (NoSuchElementException e){
            System.out.println("Not found:   " + stringcss1 + "    " + stringcss2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        //return driver.findElement(new By.ByCssSelector(stringcss)).getText();
    }
    public String[] getAllSelectorX(String stringcss1, String stringcss2) {
        System.out.println("stringcss1=    " + stringcss1);
        System.out.println("stringcss2=    " + stringcss2);
        String[] outputArray = new String[5];
        try {
            outputArray[0]= (
                    "getTagName() gives: " +
                            driver.findElement(new By.ByCssSelector(stringcss1)).getTagName()
            );
            outputArray[1]= (
                    "getText() gives: " +
                            //driver.findElement(new By.ByCssSelector(stringcss)).getAttribute()
                            driver.findElement(new By.ByCssSelector(stringcss1)).getText()
            );
            outputArray[2]= (
                    "getAtrribute("+stringcss2 +") gives: " +
                            //todo attribute uit nieuw tekstveld;
                            //driver.findElement(new By.ByCssSelector(stringcss)).getAttribute()
                            driver.findElement(new By.ByCssSelector(stringcss1)).getAttribute(stringcss2)
            );
            System.out.println("[2] ="+outputArray[2]);
            outputArray[3]= (
                    "//hasChildNodes() gives: " +
                            //todo attribute uit nieuw tekstveld;
                            //driver.findElement(new By.ByCssSelector(stringcss)).getAttribute()
                            driver.findElement(new By.ByCssSelector(stringcss1)).getAttribute(stringcss2)
            );
            outputArray[4]= (
                    "//getAtrribute(\"class\") gives: " +
                            //todo attribute uit nieuw tekstveld;
                            //driver.findElement(new By.ByCssSelector(stringcss)).getAttribute()
                            driver.findElement(new By.ByCssSelector(stringcss1)).getAttribute(stringcss2)
            );
            outputArray[3]= ("-----");
            outputArray[4]= ("-----");
        }
        catch (NoSuchElementException e){
            System.out.println("Not found:   " + stringcss1 + "    " + stringcss2);
            String[] notfound = new String()[];
            notfound[0] = {"Not Found"};
            notfound[1] = {"Not Found"};
            notfound[2] = {"Not Found"};
            notfound[3] = {"Not Found"};
            notfound[4] = {"Not Found"};
            return notfound;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return outputArray;
        //return driver.findElement(new By.ByCssSelector(stringcss)).getText();
    }

    public /*NamedNodeMap*/ void getNNM(String stringcss1, String stringcss2) {
        System.out.println(driver.findElement(new By.ByCssSelector(stringcss1)).getCssValue(stringcss2));
        //driver.findElement(new By.ByCssSelector(stringcss1)).getCssValue(stringcss2);
    }

    public void mouseOver(String cssstring1, String choiceBrowser) {
        Actions builder = new Actions(driver);
        //builder.moveToElement(hoverElement).perform();
        try {
            builder.moveToElement(driver.findElement(new By.ByCssSelector(cssstring1))).perform();
            //driver.findElement(new By.ByCssSelector("#tooltip > div > div.data > b:nth-child(1)"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mouseClick(String cssstring1, String choiceBrowser) {
        try {


            //if(choiceBrowser=="Shell") driver.findElement(By.cssSelector(""+cssstring1+"")).click();//WORKS FOR SHELL BROWSER
            //if(choiceBrowser=="Manual") browser2.getDriver().findElement(By.cssSelector(""+cssstring1+"")).click();//WORKS FOR MANUAL BROWSER

            if(choiceBrowser=="Shell") driver.findElement(By.cssSelector(cssstring1)).click();
            if(choiceBrowser=="Manual") browser2.getDriver().findElement(By.cssSelector(""+cssstring1+"")).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String makeReport(boolean pngCheck, boolean HTMLCheck){
        System.out.println("makeReport() called");
/*
        Browser b = new Browser();
        Browser b1 = new Browser();//(new ChromeDriver());
        b1.setDriver(new ChromeDriver());
        b1.go("http://www.liveleak.com");
*/


//TODO
        /*
        ScreenshotReporter screenshotReporter1 = new ScreenshotReporter();
        //ReportState reportstate1 = new ReportState(browser1,"label"+new FunctionsDaoETS2().getDateString(),new File("F:\\Users\\E\\ETScanner2\\reports\\ETS2"));
        ReportState reportstate1 = new ReportState(browser2,"label"+new FunctionsDaoETS2().getDateString(),new File("F:\\Users\\E\\ETScanner2\\reports\\ETS2"));
        //browser1 komt van bovenaan DAOets
        screenshotReporter1.writeReport(reportstate1);
  */
        //ScreenshotReporter sr = new ScreenshotReporter();
        ScreenshotReporter screenshotReporter1 = new ScreenshotReporter();
        PageSourceReporter pageSourceReporter1 = new PageSourceReporter();
        String dateText = new FunctionsDaoETS2().getDateString()
        ReportState reportstate1 = new ReportState(browser2,"label"+dateText,new File("F:\\Users\\E\\ETScanner2\\reports\\ETS2"));
        //sr.writeReport(new ReportState(browser1,"label123",new File("F:\\Users\\E\\ETScanner2\\reports\\ETS2")));
        if(pngCheck)screenshotReporter1.writeReport(reportstate1);
        if(HTMLCheck)pageSourceReporter1.writeReport(reportstate1);
        //ReportState reportstate1 = new ReportState(browser1,"label"+new FunctionsDaoETS1().getDateString(),new File("F:\\Users\\E\\ETScanner1\\reports\\ETS1"));

          //ReportState reportstate1 = new ReportState(browser1,"label123",new File("F:\\Users\\E\\ETScanner1\\reports\\ETS1"));
          //reportstate.setProperty("class",geb.report.Base64);
          //reportstate.setProperty();



    return dateText;
    }




String RunGroovyShell(String string1) {
    //String returnvalue = "println \"Hello22222\"";
    String returnvalue = "startvalue returnvalue";

    //String

    // browser2.getDriver().findElement(By.id(stringstring)).click();
    //browser2.getDriver().findElement(By.cssSelector(stringstring)).click();
    //returnvalue="browser2.getDriver().findElement(By.cssSelector("+stringstring+")).click();"//werkt niet want geen browser2 zichtbaar
    //GOODTRYNOTWORKING returnvalue= new String("Label1:{browser2.getDriver().findElement(By.cssSelector("+string1+")).click();}")

//                returnvalue="println \"Hello22222\"";

    //Binding binding = new Binding();
    GroovyShell shell = new GroovyShell();
    //shell.run(new File("F:/Users/E/ETScanner2/src/main/java/ETS2/GroovyScript01.groovy"));
    //shell.run(new File("F:\\Users\\E\\ETScanner2\\src\\main\\java\\ETS2\\eSuite_MP_AFS_04_Maak_afspraak_Spec.groovy"));

/*
    shell.run(new File("F:\\Users\\E\\ETScanner2\\src\\main\\java\\ETS2\\ScanStepsTesterA.groovy"));
    println("ScanStepsTesterA.groovy")
    shell.run(new File("F:\\Users\\E\\ETScanner2\\src\\main\\java\\ETS2\\ScanStepsTesterB.groovy"));
    println("ScanStepsTesterB.groovy")
*/

    //driver = new GebConfigExtraETS2().getDriver("chrome", "nl")
    shell.run(new File(string1));//WORKS!!
    //shell.run(new File(string1),"Click on something()");//dit werkt niet, pakt gewoon string1 zonder rest te checken.??
    String x = new File(string1).toString();
    returnvalue =x;
    //Object value = shell.evaluate("for (x=0; x<5; x++){println \"Hello\"}; return x"); //prints 5 times hello
    //Object value = shell.evaluate(returnvalue);


    return returnvalue
}

    String RunProcessBuilder(String string1) {
        String returnvalue = "startvalue returnvalue";
        //Binding binding = new Binding();
/*        GroovyShell shell = new GroovyShell();
        shell.run(new File(string1));//WORKS!!
        String x = new File(string1).toString();
        returnvalue =x;*/
        //println "textAlt"
        //executeOnShell(string1, new File("F:/Users/E/medewerkers-it/src"));
        //executeOnShell(string1, new File("F:/Users/E/ETScanner2/src"));
       // executeOnShell(string1, new File("F:/Users/E/ETScanner2/"));
        //driver = new GebConfigExtraETS2().getDriver("chrome", "nl")



        //executeOnShell(string1, new File("F:/Users/E/ETScanner2/src"));
        //executeOnShell(string1, new File("F:\\Users\\E\\medewerkers-it"));//WTF WAAROM
        executeOnShell(string1, new File("F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1"));//WTF WAAROM

        String current = new java.io.File( "." ).getCanonicalPath();
        //System.out.println("Current dir1:"+current);
        //println "XX22"
        String currentDir = System.getProperty("user.dir");
        //System.out.println("Current dir using System1:" +currentDir);
        //todo twee keer currentdit
       // print System.getProperties()
        //F:\Users\E\ETScanner2\src\ETS2
        //F:\Users\E\ETScanner2\target\classes\ETS2
        //println "XX22b"

        return returnvalue
    }

//-----------below is experiment with processbuilder

    String executeOnShell(String fileNameScript, File workingDir) {

        //println "Commandx = "+ fileNameScript
        //println "WORKING DIRx = " + workingDir
        //println "XX22"
        //println addShellPrefix(fileNameScript)
        try{
            //Process process = new ProcessBuilder(addShellPrefix(fileNameScript)).directory(new File("D:\\")).redirectErrorStream(true).start()
            //Process process = new ProcessBuilder(addShellPrefix(fileNameScript)).directory(workingDir).redirectErrorStream(true).start()
            Process process = new ProcessBuilder(addShellPrefix(fileNameScript)).redirectErrorStream(true).start()

            //TODO BACK Process process = new ProcessBuilder(addShellPrefix(fileNameScript)).directory(workingDir)  .redirectErrorStream(true).start()                  .redirectErrorStream(true).start()

            //sleep(2000)
//            println "exitvalue=" + process.exitValue()
            //process.waitFor();//TODO BACK






        //println "XX3"
        //sleep(2000)
        //
        process.inputStream.eachLine {
            String x = it;
            //println x
            if(x.contains("JUnit")){
                System.out.println("WRITE RESULT TO SOMEWHERE??? : " + x)
                //System.exit(4);
                //process.inputStream=null;
                //process.destroy()
                return;
            }
            //else System.out.println("Not::: " + x)

        }

        /*for(int i=1;i<10;i++){
            println "getP " + process.inputStream.getProperties();
            Thread.sleep(2000)
        }*/
        }
        catch (Exception e){
            e.printStackTrace()
        }
        String line = "";
        //"JUnit 4 Runner"
        /*while{!line.contains("Junit"){
            System.out.println("hallo");
            line="Junit";

        }*/
        //line = process.inputStream.eachLine {println "######"+ it}
        //println process.inputStream.getProperties()
        //println "XX4"
        //println "TextExecuteOnShell\n"
        //TODO JUST REMOVED sleep(2000)
        //process.exitValue()
        return "ok"
    }

    private def addShellPrefix(String fileNameScript) {
        String[] commandArray = new String[6]
        //commandArray[0] = "C:\\cygwin64\\bin\\sh"
        commandArray[0] = "F:/SeleniumDownloadFolder/apache-groovy-binary-2.4.5/groovy-2.4.5/bin/groovy.bat" //CCCCC OF   GEEEEN CCCC
        commandArray[1] = "-cp"
        commandArray[2]= "\"F:/SeleniumDownloadFolder;F:/SeleniumDownloadFolder/geb-spock-0.12.2;C:/Users/E/.m2/repository/org/spockframework/spock-core/1.0-groovy-2.4;F:/SeleniumDownloadFolder/Test_JAR_uitpakken/spock-core-1.0-groovy-2.4;C:/Users/E/.m2/repository/org/gebish/geb-core/0.12.2;F:/SeleniumDownloadFolder/Test_JAR_uitpakken/geb-core-0.12.2;F:/SeleniumDownloadFolder/Test_JAR_uitpakken/geb-core-0.12.2/geb/error;C:/Users/E/.m2/repository/org/gebish/geb-core/0.12.2/geb-core-0.12.2.jar;F:/SeleniumDownloadFolder/geb-spock-0.12.2/geb/spock;.;F:\\SeleniumDownloadFolder\\Test_JAR_uitpakken\\geb-exceptions-0.12.2;F:\\SeleniumDownloadFolder\\Test_JAR_uitpakken\\selenium-api-2.45.0;F:\\SeleniumDownloadFolder\\Test_JAR_uitpakken\\selenium-server-2.45.0;F:\\SeleniumDownloadFolder\\Test_JAR_uitpakken\\geb-waiting-0.12.2;F:\\Users\\E\\ETScanner2\\src\\main\\java;F:\\SeleniumDownloadFolder\\Test_JAR_uitpakken\\selenium-server-standalone-2.45.0;F:\\Users\\E\\ETScanner2\\src\\main\\java\\ETS2;F:\\Users\\E\\ETScanner2\\target\\classes;F:\\Users\\E\\medewerkers-it\\src\\test\\groovy\\pageobjects\\contact;F:\\Users\\E\\medewerkers-it\\target\\test-classes\\pageobjects\\contact;F:\\Users\\E\\medewerkers-it\\target\\test-classes;F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\target\\classes\\com\\ETMS1;F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\target\\test-classes;F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\target\\classes;F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\target\\classes\\com\\ETMS1;C:\\Users\\E\\.m2\\repository\\org\\gebish\\geb-implicit-assertions\\0.13.1;C:\\Users\\E\\.m2\\repository\\org\\gebish\\geb-implicit-assertions\\0.13.1\\geb-implicit-assertions-0.13.1.jar;C:\\Users\\E\\.m2\\repository\\org\\gebish\\geb-ast\\0.13.1\\geb-ast-0.13.1.jar;C:\\Program Files\\Java\\jdk1.7.0_79\\jre\\lib\\jfxrt.jar;C:\\Users\\E\\.m2\\repository\\org\\xerial\\sqlite-jdbc\\3.8.11.2\\sqlite-jdbc-3.8.11.2.jar\""

        //commandArray[2] = commandArray[2]+"xxxxx"
       // commandArray[3] = "\""+fileNameScript + "\" "// + "org.junit.runner.JUnitCore positive"
        commandArray[3] = fileNameScript
        // commandArray[3] = "\""+fileNameScript + "\" " + ">> outputAAAAA.log"
        commandArray[4] = ">>"
            /*String dateText = "output_" + new FunctionsDaoETS2().getDateString()+ ".log"
            //commandArray[5] = dateText*/
        commandArray[5] = fileName
        //println "COMMANARR= "+ commandArray[0] + " " + commandArray[1] + " " + commandArray[2] + " " + commandArray[3] + " " + commandArray[4]+ " " + commandArray[5]
        return commandArray
    }
    public static void storeDriver(WebDriver wd){
        driver = wd;
    }
    public static WebDriver giveDriver(){
        return driver;
    }

    String SandBox(String string1) {
        String returnvalue = "startvalue returnvalue";
        StringBuilder builderFileA;
        String FileB;
        String FileC;

        try {
            //String x = new File(string1).toString();
            //File file1 = new File(string1);
            //returnvalue = new File(string1).text
            int number=5
            int deffoundindex1=0;
            builderFileA = new StringBuilder(new File(string1).text);

            for(int i = 0 ;i<number ;i++){



                Integer statementstart=0
                int statementend=0
                int nextopenbracket=0
                int nextclosebracket=0
                String defname
                deffoundindex1 = builderFileA.indexOf("def \"",deffoundindex1);
                println "deffoundindex1 =====================" + deffoundindex1

                nextopenbracket = builderFileA.indexOf("{",deffoundindex1);
                statementstart = nextopenbracket
                defname = builderFileA.toString().substring(deffoundindex1,nextopenbracket)
                int amountOpenBrackets = 1;
                nextclosebracket = deffoundindex1;
                while(amountOpenBrackets>0){
                    nextopenbracket = builderFileA.indexOf("{",++nextopenbracket);
                    nextclosebracket = builderFileA.indexOf("}",++nextclosebracket);
                    if(nextopenbracket==-1||nextclosebracket<nextopenbracket){
                        statementend=nextclosebracket
                        amountOpenBrackets--;
                        println("nextopenbracket is:" + nextopenbracket)
                        println("nextclosebracket is:" + nextclosebracket)
                        println("Start is:" + statementstart)
                        println("End is  :" + statementend)
                    }
                }
                println "deffoundindex1 =====================" + deffoundindex1
                println("Start result is:" + statementstart)
                println("End result  is  :" + statementend)
                //builderFileA.delete(deffoundindex1,statementend+1)
                builderFileA.replace(deffoundindex1,statementend+1,("/*"+defname+" REMOVED*/"))
                deffoundindex1=statementstart
                println "statementstart =x=x==" + statementstart + " \n"
            }




/*            for(int i = 0 ; ;i++){
                deffoundindex1 = builderFileA.indexOf("def \"",deffoundindex1);
                System.out.println("indexof: " + deffoundindex1);

                deffoundindex2 = builderFileA.indexOf("def \"",deffoundindex1+1);
                System.out.println("indexof: " + deffoundindex2);

                builderFileA = new StringBuilder(builderFileA);
                if(deffoundindex2==-1)break;
                builderFileA.delete(deffoundindex1,deffoundindex2)
            }
*/


            returnvalue = builderFileA

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return returnvalue
    }
    String RunGroovyShellMulti(String string1x) {
        String returnvalue = "startvalue returnvalue";
        GroovyShell shell = new GroovyShell();
        System.out.println("Check x01");
        shell.run(new File(string1x));//WORKS!!
        String x = new File(string1x).toString();
        returnvalue =x;
        return returnvalue
    }

    static String ShellToFixRestoreChrome(File fileName, int number){
        //File complete = new File(fileName);
        //File workingDir = new File("Y:");
        //File workingDir = new File(fileName)
/*TODO VERY GOOD HERE set it back later
        String[] commandArray = ["sed","-i","'s/\"exit_type\":\"Crashed\"/\"exit_type\":\"Normal\"/'",fileName.toString()+"/Preferences"]
        ////String[] commandArray = ["sed","-i","'s/\"www.google.com\"/\"www.nu.nl\"/'",fileName.toString()+"/Preferences"]
        println commandArray.toString()
        def process = new ProcessBuilder(commandArray).directory(new File(fileName.absolutePath)).redirectErrorStream(true).start()
        process.waitFor();
*/
        int widthbrowser = 600;
        int heightbrowser = 450;
        int xcoord = number*widthbrowser;
        int ycoord=0;
        if(number>=3){
            ycoord=heightbrowser+50
            xcoord = (number-3)*widthbrowser;
        };

        String totalString = "{\"account_id_migration_state\":2,\"account_tracker_service_last_update\":\"13130176321058392\",\"alternate_error_pages\":{\"enabled\":false},\"autofill\":{\"enabled\":false},\"browser\":{\"clear_lso_data_enabled\":true,\"pepper_flash_settings_enabled\":true,\"window_placement\":{\"bottom\":"+(ycoord+heightbrowser)+",\"docked\":false,\"left\":"+xcoord+",\"maximized\":false,\"right\":"+(xcoord+widthbrowser)+",\"top\":"+ycoord+",\"work_area_bottom\":1040,\"work_area_left\":0,\"work_area_right\":1920,\"work_area_top\":0}},\"countryid_at_install\":18242,\"data_reduction\":{\"daily_original_length\":[\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"963064\",\"890284\",\"0\",\"68607\",\"66782\"],\"daily_original_length_application\":\"63431\",\"daily_original_length_unknown\":\"0\",\"daily_original_length_via_data_reduction_proxy\":[\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\"],\"daily_original_length_via_data_reduction_proxy_application\":\"0\",\"daily_original_length_via_data_reduction_proxy_unknown\":\"0\",\"daily_original_length_via_data_reduction_proxy_video\":\"0\",\"daily_original_length_video\":\"0\",\"daily_original_length_with_data_reduction_proxy_enabled\":[\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\"],\"daily_original_length_with_data_reduction_proxy_enabled_application\":\"0\",\"daily_original_length_with_data_reduction_proxy_enabled_unknown\":\"0\",\"daily_original_length_with_data_reduction_proxy_enabled_video\":\"0\",\"daily_received_length\":[\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"963064\",\"890284\",\"0\",\"68607\",\"66782\"],\"daily_received_length_application\":\"63431\",\"daily_received_length_https_with_data_reduction_proxy_enabled\":[\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\"],\"daily_received_length_long_bypass_with_data_reduction_proxy_enabled\":[\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\"],\"daily_received_length_short_bypass_with_data_reduction_proxy_enabled\":[\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\"],\"daily_received_length_unknown\":\"0\",\"daily_received_length_unknown_with_data_reduction_proxy_enabled\":[\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\"],\"daily_received_length_via_data_reduction_proxy\":[\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\"],\"daily_received_length_via_data_reduction_proxy_application\":\"0\",\"daily_received_length_via_data_reduction_proxy_unknown\":\"0\",\"daily_received_length_via_data_reduction_proxy_video\":\"0\",\"daily_received_length_video\":\"0\",\"daily_received_length_with_data_reduction_proxy_enabled\":[\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\",\"0\"],\"daily_received_length_with_data_reduction_proxy_enabled_application\":\"0\",\"daily_received_length_with_data_reduction_proxy_enabled_unknown\":\"0\",\"daily_received_length_with_data_reduction_proxy_enabled_video\":\"0\",\"last_update_date\":\"13130204400000000\"},\"data_reduction_lo_fi\":{\"load_images_requests_per_session\":0,\"load_images_snackbars_shown_per_session\":0,\"was_used_this_session\":false},\"distribution\":{\"import_bookmarks\":false,\"import_history\":false,\"import_search_engine\":false,\"make_chrome_default_for_user\":false,\"show_welcome_page\":false,\"skip_first_run_ui\":true},\"dns_prefetching\":{\"host_referral_list\":[2,[\"https://www.google.com/\",[\"https://apis.google.com/\",1.0000158651778477,\"https://ssl.gstatic.com/\",2.000031733586277,\"https://www.google.com/\",13.04309225294957,\"https://www.gstatic.com/\",1.000026338816212]]],\"startup_list\":[1,\"http://localhost:63342/\",\"https://apis.google.com/\",\"https://ssl.gstatic.com/\",\"https://www.google.com/\",\"https://www.gstatic.com/\"]},\"download\":{\"directory_upgrade\":true},\"extensions\":{\"alerts\":{\"initialized\":true},\"autoupdate\":{\"last_check\":\"13130002550094609\",\"next_check\":\"13130207554207488\"},\"chrome_url_overrides\":{\"bookmarks\":[{\"active\":true,\"entry\":\"chrome-extension://eemcgdkfndhakfknompkggombfjjjeno/main.html\"}]}},\"gcm\":{\"product_category_for_subtypes\":\"com.chrome.windows\"},\"http_original_content_length\":\"5729801\",\"http_received_content_length\":\"5729801\",\"intl\":{\"accept_languages\":\"nl\"},\"invalidator\":{\"client_id\":\"LixqD7w+r+T8IMVLP9SkjQ==\"},\"language_model_counters\":{\"en\":2,\"und\":363},\"media\":{\"device_id_salt\":\"KD/tPkSyjkKuETyQrycJrw==\"},\"net\":{\"http_server_properties\":{\"servers\":[{\"ssl.gstatic.com:443\":{\"supports_spdy\":true}},{\"www.google.com:443\":{\"supports_spdy\":true}},{\"www.facebook.com:443\":{\"supports_spdy\":true}},{\"staticxx.facebook.com:443\":{\"supports_spdy\":true}},{\"beacons.gvt2.com:443\":{\"supports_spdy\":true}}],\"version\":4}},\"partition\":{\"per_host_zoom_levels\":{\"2166136261\":{\"nos.nl\":1.2239010857415449}}},\"plugins\":{\"npapi_flash_migrated_to_pepper_flash\":true,\"plugins_list\":[]},\"profile\":{\"avatar_index\":26,\"content_settings\":{\"domain_to_origin_migration_status\":1,\"exceptions\":{\"app_banner\":{},\"auto_select_certificate\":{},\"automatic_downloads\":{},\"autoplay\":{},\"background_sync\":{},\"bluetooth_guard\":{},\"cookies\":{},\"durable_storage\":{},\"fullscreen\":{},\"geolocation\":{},\"images\":{},\"important_site_info\":{},\"javascript\":{},\"keygen\":{},\"media_stream_camera\":{},\"media_stream_mic\":{},\"midi_sysex\":{},\"mixed_script\":{},\"mouselock\":{},\"notifications\":{},\"plugins\":{},\"popups\":{},\"ppapi_broker\":{},\"prompt_no_decision_count\":{},\"protocol_handler\":{},\"push_messaging\":{},\"site_engagement\":{\"http://localhost:63342,*\":{\"setting\":{\"lastEngagementTime\":13130207410185612.0,\"lastShortcutLaunchTime\":0.0,\"pointsAddedToday\":12.0,\"rawScore\":37.46672322483374}}},\"ssl_cert_decisions\":{},\"usb_chooser_data\":{}},\"pattern_pairs\":{\"https://*,*\":{\"media-stream\":{\"audio\":\"Default\",\"video\":\"Default\"}}},\"pref_version\":1},\"default_content_settings\":{\"geolocation\":1,\"mouselock\":1,\"notifications\":1,\"popups\":1,\"ppapi-broker\":1},\"exit_type\":\"Crashed\",\"exited_cleanly\":true,\"last_engagement_time\":\"13130207410185613\",\"managed_user_id\":\"\",\"name\":\"Person 1\",\"password_manager_enabled\":false},\"protection\":{\"macs\":{}},\"safebrowsing\":{\"enabled\":false},\"search\":{\"suggest_enabled\":false},\"spellcheck\":{\"dictionaries\":[\"en-GB\"],\"dictionary\":\"\"},\"toolbar_migrated_component_action_status\":{},\"translate\":{\"enabled\":false}}"
        //FileOutputStream fos = new FileOutputStream("Y:\\Browser_profile0\\Default/Preferences2");

        //File file = new File("Y:\\Browser_profile0\\Default/Preferences")
        println "WRITING NEW PREF"+fileName.toString()
        File file = fileName;
        FileWriter fw = new FileWriter(file);
        BufferedWriter bfw = new BufferedWriter(fw)

        bfw.write(totalString);
        bfw.flush()
        bfw.close()

        //def process = new ProcessBuilder(commandArray).directory(complete.absolutePath).redirectErrorStream(true).start()
        //haal rest uit javaklad.java.txt
    }
    static int teller=2;
    int getNumberOfActiveBrowsersx(){
        System.out.println("getNumberOfActiveBrowsers = " + numberOfActiveBrowsers);
        teller++;
        System.out.println("teller = " + teller);
        //return numberOfActiveBrowsers;
        return teller;
    }

    void setnumberOfActiveBrowsersx(int number){
        System.out.println("setNumberOfActiveBrowsers = " + number);
        this.numberOfActiveBrowsers = number;
        System.out.println("numberOfActiveBrowsers = " + numberOfActiveBrowsers);
    }

    int giveAvailableBrowserx(){
        for(int i=0;i<totalAmountBrowserprofiles;i++){

        }

        return
    }

    synchronized static public int getNewBrowserNumber(){
        //System.out.println("numberOfActiveBrowsers=" + numberOfActiveBrowsers);
        numberOfActiveBrowsers++;
        //System.out.println("numberOfActiveBrowsers=" + numberOfActiveBrowsers);
        return numberOfActiveBrowsers;
    }
    @Override
    void run() {
        //RunGroovyShellMulti("F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\src\\main\\java\\com\\ETMS1\\TestCase01.groovy");PERFFECT
        //this.RunProcessBuilder("F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\src\\main\\java\\com\\ETMS1\\ProcTestCase01xx.groovy");OOK PERFECT 2017
        this.RunProcessBuilder("F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\src\\main\\java\\com\\ETMS1\\ProcTestCase01xx.groovy")
        //System.out.println("run text");
        //JvmThreadInstanceEntryImpl.ThreadStateMap ts = new JvmThreadInstanceEntryImpl.ThreadStateMap();
        //ts.
    }

}
