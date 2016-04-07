package com.ETMS1;

import DAO_PACKAGE.SQLiteJDBC_DAO;

import java.util.UUID;

/**
 * Generate a unique number
 */
public class App {

    public static void main(String[] args) {
        App obj = new App();
        System.out.println("Unique ID : " + obj.generateUniqueKey());
        //WebDriver chromedriver = new ChromeDriver();
        // WebDriver ffdriver = new FirefoxDriver();
        //WebDriver iedriver = new InternetExplorerDriver();
        //String url1 = "http://www.gebish.org";
        /*String url1 = "http://localhost:63342/QuickHtml/htmlApp.html";

        SelTestGroovy selTest1 = new SelTestGroovy(url1,"chrome",1);
        SelTestGroovy selTest2 = new SelTestGroovy(url1,"chrome",2);
        SelTestGroovy selTest3 = new SelTestGroovy(url1,"chrome",3);
        SelTestGroovy selTest4 = new SelTestGroovy(url1,"chrome",4);
        SelTestGroovy selTest5 = new SelTestGroovy(url1,"chrome",5);
        SelTestGroovy selTest6 = new SelTestGroovy(url1,"chrome",6);

        //SelTestGroovy selTest3 = new SelTestGroovy("http://www.google.nl","chrome",3);
        //SelTestGroovy selTest4 = new SelTestGroovy("https://github.com","firefox",4);
        //SelTestGroovy selTest5 = new SelTestGroovy("https://github.com","ie",5);
        Thread thread1 = new Thread(selTest1);
        Thread thread2 = new Thread(selTest2);
        Thread thread3 = new Thread(selTest3);
        Thread thread4 = new Thread(selTest4);
        Thread thread5 = new Thread(selTest5);
        Thread thread6 = new Thread(selTest6);
        thread1.start();
        //thread2.start();
        //thread3.start();
        //thread4.start();
        //thread5.start();
        //thread6.start();
*/
        //SQLiteJDBC_Create.creatego();
        //SQLiteJDBC_Insert_RESULT_VALUES.resetTableBrowserSharing();
        //SQLiteJDBC_DAO.resetTableBrowserSharing();
        //System.out.println("lastist"+SQLiteJDBC_Insert_RESULT_VALUES.getLastID());
//        System.out.println("lastist"+ SQLiteJDBC_Select_RESULT_VALUES.findFree());

        int browsernumber = -1;
        //browsernumber = SQLiteJDBC_Select_RESULT_VALUES.findFree();
        browsernumber = SQLiteJDBC_DAO.findFree();
        System.out.println("received : " + browsernumber);
        if (browsernumber == -1) {
            System.out.println("No available browsers! : " + browsernumber);

        }
        //else SQLiteJDBC_Insert_RESULT_VALUES.takebrowser(browsernumber, "output123.123.123.log", "TAKEN");
        else SQLiteJDBC_DAO.takeBrowser(browsernumber, "TestCase x123", "TAKEN");

        SQLiteJDBC_DAO.giveback(2,"NULL","FREE");
    }

    public String generateUniqueKey() {

        String id = UUID.randomUUID().toString();
        return id;

    }
}
