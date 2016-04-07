package com.ETMS1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import com.ETMS1.SmallGroovy;

public class AppTest {

	@Test
	public void testLengthOfTheUniqueKey() {

		App obj = new App();
		new App().toString();
		//new SelTest().TestCCC();
		Assert.assertEquals(36, obj.generateUniqueKey().length());
		//System.out.println("testLengthOfTheUniqueKey @Ttest HERE!!!!!!!!!!!!!!!!!!!!!!!");
		//new SmallGroovy().toString();
		//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!" + new SmallGroovy().getTwo() + " ");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
		//new SmallGroovy().Test222();
		WebDriver chromedriver = new ChromeDriver();
		WebDriver ffdriver = new FirefoxDriver();
		WebDriver iedriver = new InternetExplorerDriver();
		SelTest selTest1 = new SelTest("http://www.nu.nl",chromedriver);
		SelTest selTest2 = new SelTest("http://www.nu.nl",ffdriver);
		SelTest selTest3 = new SelTest("http://www.nu.nl",iedriver);
		Thread thread1 = new Thread(selTest1);
		Thread thread2 = new Thread(selTest2);
		Thread thread3 = new Thread(selTest3);
		thread1.start();
		thread2.start();
		thread3.start();
		//cc.TestSelenium();

	}
}
