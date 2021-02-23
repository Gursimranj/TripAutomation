package au.com.automation.stepdefinitions;
import au.com.automation.pages.TestBase;
import cucumber.api.Scenario;
import au.com.automation.enums.Browsers;
import au.com.automation.helper.Logger;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class ServiceHooks {

	private String browser="";
	TestBase testBase;

	org.apache.log4j.Logger log = Logger.getLogger(ServiceHooks.class);

	@Before
	public void initializeTest() {
		testBase = new TestBase();
		try {
			log.info("capturing maven properties");
			browser = System.getProperty("browser");



			log.info("browser passed through maven " + browser);

		}
		catch(Exception e){
			log.info("Could not get the broserName from getProperty");
		}
		try {
			log.info("capturing propertites");
			browser = System.getenv("browser");



			log.info("browser passed through Jenkins " + browser);

		}
		catch(Exception e){
			log.info("Could not get the browserName from Jenkins");
		}

		if(browser==null){
			browser = Browsers.CHROME.name();
		}
		else
			log.info("Dynamic browser name passed through maven CLI-" + browser);
		testBase.selectBrowser(browser);
	}

	@After
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {

			try {
				log.info(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png"); // ... and embed it in
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				log.info(scenario.getName() + " is pass");
				scenario.embed(((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES), "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		TestBase.driver.quit();
	}
}
