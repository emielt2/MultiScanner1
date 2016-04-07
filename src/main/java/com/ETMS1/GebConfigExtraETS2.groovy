package com.ETMS1
/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import geb.Browser
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver


waiting {
	timeout = 2
}
//------------------------------------------------------------------------------------------



import com.gargoylesoftware.htmlunit.BrowserVersion
import com.gargoylesoftware.htmlunit.WebClient
import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile

import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

import java.util.logging.Level
import java.util.logging.Logger

WebDriver extraDriver;

public WebDriver getDriver(def browser, def String language,int number) {

	if ("chrome".equalsIgnoreCase(browser)) {
		println "this is webdriver stuff in gebconfig"//ETADD
		DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("user-data-dir=Y:\\Browser_profile"+number);//ETADD
		//println (browserpath.toString())
		File googleprefenerences = new File(new String("user-data-dir=Y:/Browser_profile" + number + "/Default/Preferences"))

		println chromeOptions.getProperties()
		println()
		println chromeCapabilities.getProperties()
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("intl.accept_languages", language);
		chromeOptions.setExperimentalOption("prefs", prefs);
		chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions)
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDownloadFolder\\chromedriver_win32\\chromedriver.exe");
		def chromeDriver = new ChromeDriver(chromeCapabilities)
		//chromeDriver.get("https://www.esosuite.net/");
		//chromeDriver.manage().window().maximize()
		//this.webDriverA = chromeDriver
		return chromeDriver

	} else if ("firefox".equalsIgnoreCase(browser)) {

		FirefoxProfile profile = new FirefoxProfile()
		profile.setPreference("intl.accept_languages", language)
		def firefoxDriver = new FirefoxDriver(profile)
		firefoxDriver.manage().window().maximize()
		firefoxDriver

	} else if ("ie".equalsIgnoreCase(browser)) {

		/**
		 * For InternetExplorer: In order to set the browser language to 'EN' or 'NL',
		 *  Go to, Settings -> Internet Options -> General ->
		 *  - Click on the button 'Languages'
		 *  - In the Language text box,
		 *    Add the desired language "Dutch (Netherlands) [nl-NL]" or "English (United States) [en-US]"
		 *    and move it up by clicking 'Move up' button
		 *
		 */
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer()
		ieCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false)
		ieCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false)
		ieCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true)
		ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
		ieCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true)
		ieCapabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
		ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true)
		ieCapabilities.setJavascriptEnabled(true);
		def ieDriver = new InternetExplorerDriver(ieCapabilities)
		ieDriver.manage().window().maximize()
		ieDriver


	}

}
