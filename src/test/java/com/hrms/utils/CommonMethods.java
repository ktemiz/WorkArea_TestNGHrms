package com.hrms.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.PageInitializer;



public class CommonMethods extends PageInitializer {
	
	/**
	 * Method that clears and send keys
	 * @param element
	 * @param text
	 */
	
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	
	}
	/**
	 * Method verify that text is displayed and match with expected value
	 * @param element
	 * @param text
	 * @return boolean
	 */
	
	public static boolean verifyTextAndDisplay(WebElement element, String text) {
		String actualText = element.getText();
		if(element.isDisplayed()) {
			if(actualText.toLowerCase().trim().equals(text)) {
			System.out.println(actualText+ " is displayed matched with expectedValue");
			return true;
		}else {
			System.out.println(actualText+ "is displayed but not matched with expectedValue.");
			return false;
		}
		}else {
			System.out.println("Text is not displayed");
			return false;
		}
	}
	

	/**
	 * Method checks if radio/checkbox is enabled and clicks it
	 * @param radioOrcheckbox
	 * @param value
	 */
	public static void clickRadioOrCheckbox(List<WebElement> radioOrcheckbox, String value) {
		
		String actualValue;
		
		for(WebElement el:radioOrcheckbox) {
			actualValue=el.getAttribute("value").trim();
			if(el.isEnabled()&& actualValue.equals(value)) {
				el.click();
				break;
			}
		}
	
	}
	
	/**
	 * Method that checks if text is there and then selects it
	 * 
	 * @param element
	 * @param textToSelect
	 */
	public static void selectDdValue(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();

			for (WebElement el : options) {
				if (el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that selects value by index
	 * @param element
	 * @param index
	 */
	public static void selectDdValue(WebElement element, int index) {

		try {
			Select select = new Select(element);
			int size = select.getOptions().size();
			
			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Methods that accept alerts and catches exception if alert is not present
	 */
	public static void acceptAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Methods that dismiss alerts and catches exception if alert is not present
	 */
	public static void dismissAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Methods that gets text of alert and catches exception if alert is not present
	 * 
	 * @return String alert text
	 */
	public static String getAlertText() {

		String alertText = null;

		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}

	/**
	 * Methods that sends text to alert and catches exception if alert is not
	 * present
	 * 
	 */
	public static void sendAlertText(String text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	public static void switchToFrame(String nameOrId) {

		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(int index) {
		
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method switches focus to child window
	 */
	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}
	
	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	
	/**
	 * move to mouse curser on the target element
	 * @param element
	 */
	
	public static void moveCursor(WebElement element) {
		
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
	}

	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Method that will scroll the page down based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * Method that will scroll the page up based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	
	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void takeScreenShot(String filename) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File("screenshots/HRM/"+filename+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
	
		
	
