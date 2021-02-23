package au.com.automation.pages;

import au.com.automation.helper.Constants;
import au.com.automation.helper.WaitHelper;
import au.com.automation.pageObjects.tripPlannerObjects;
import org.apache.commons.lang.RandomStringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tripPlannerPage {
    private WebDriver driver;
    WaitHelper waitHelper;

    public tripPlannerPage(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);

    }

    public void navigateToURL(){
        driver.get(Constants.mainUrl);
    }

    public void originLocationText(String fromLocation, String toLocation){
        tripPlannerObjects.originLocation(driver).sendKeys(fromLocation);
        tripPlannerObjects.destinationLocation(driver).sendKeys(toLocation);
        //enterKeyboardFunction();
    }


    public void clickOnGoBtn(){
        //waitForPageLoad();
        tripPlannerObjects.clickGo(driver).click();
    }


    public void listOfTripsProvide() throws InterruptedException {
        //Thread.sleep(4000);
        waitForPageLoad();
        List<WebElement> myElements = null;
        myElements= tripPlannerObjects.listOfTrips(driver);
         int numberOfTrips =myElements.size();
         if(numberOfTrips>0){
             System.out.println("Number of Trips"+numberOfTrips);
         }
         else {
             System.out.println("No Trips Found");
         }


    }

    public void waitForPageLoad(){
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
          public Boolean apply(WebDriver driverPage){
              return (Boolean) ((JavascriptExecutor)driverPage).executeScript("return document.readyState", new Object[0].equals("complete"));
          }
        };
        WebDriverWait wait = new WebDriverWait(driver,60L);
        wait.until(pageLoadCondition);
    }
    public String getRandomString(int count){
        boolean randomStringGenerated = false;
        String generatedString;
        do {
            generatedString = RandomStringUtils.randomAlphabetic(count);
            Pattern pattern = Pattern.compile("^.*(.)\\1\\1.*$");
            Matcher matcher = pattern.matcher(generatedString.toLowerCase());
            if (!matcher.find()) {
                randomStringGenerated = true;
            }
        }while(!randomStringGenerated);
        return generatedString;
        }

    public String getRandomInteger(int length){
        String intPool = "123456789";
        StringBuilder sb = new StringBuilder(length);
        for(int i=0; i < length; i++) {
            int index = (int)(intPool.length() * Math.random());

            sb.append(intPool.charAt(index));
        }
        return sb.toString();
    }

    public void scrollToPageEnd()
    {
        //Actions builder = new Actions(driver);
       // builder.sendKeys(new CharSequence[]{Keys.END}).perform();
        System.out.println("inside scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        System.out.println("outside scroll");
    }
    public void enterKeyboardFunction(){
        Actions action = new Actions(driver);
        action.sendKeys(new CharSequence[]{Keys.ENTER}).build().perform();
    }

}



