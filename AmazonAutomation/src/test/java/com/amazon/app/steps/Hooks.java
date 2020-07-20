package com.amazon.app.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.app.config.Config;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hooks {

	Scenario scenario;
	public static WebDriver driver;

	@AfterStep
	public void addScreenShotToReport(Scenario scenario) {
		try {
			byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenShot, "image/png");
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	@After
	public void closeBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void launchBrowser() {
		if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.chrome.driver", "./res/drivers/chromedriver.exe");

		} else if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", "./res/drivers/chromedriver");
		}
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Config.AppUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
