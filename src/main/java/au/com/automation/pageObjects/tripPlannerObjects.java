package au.com.automation.pageObjects;

import au.com.automation.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class tripPlannerObjects {
    private static WebElement element = null;
    private static List<WebElement> myElements = null;
    WaitHelper waitHelper;

    public static WebElement originLocation(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id='tniFromTripLocation']"));
        return element;
    }
    public static WebElement destinationLocation(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id='tniToTripLocation']"));
        return element;
    }
    public static WebElement clickGo(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[text()='Go']"));
        return element;
    }

    public static List<WebElement> listOfTrips(WebDriver driver) {
        myElements = driver.findElements(By.xpath("//*[@class='trip-time ng-star-inserted']"));
        return myElements;
    }
}
