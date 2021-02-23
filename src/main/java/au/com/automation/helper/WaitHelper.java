package au.com.automation.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

/**
 * 
 * @author Gursimran
 *
 */
public class WaitHelper {

	org.apache.log4j.Logger logger = Logger.getLogger(WaitHelper.class);
	
	private WebDriver driver;
	
	public WaitHelper(WebDriver driver){
		this.driver = driver;
	}
	
	public void WaitForElement(WebElement element,long timeOutInSeconds){
		logger.info("waiting for element visibilityOf..");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		logger.info("element is visible..");
	}
	public WebElement FluentWait(By by, long seconds , long intervals){
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(seconds))
					.pollingEvery(Duration.ofMillis(intervals))
					.ignoring(NoSuchElementException.class);
			WebElement element = wait.until(new Function<WebDriver, WebElement>() {

				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});
			return element;
		}catch (NoSuchElementException var4){
			return null;
		}catch (TimeoutException var5){
			return  null;
		}
	}


}
