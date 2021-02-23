package au.com.automation.stepdefinitions;

import au.com.automation.helper.Logger;
import au.com.automation.pages.TestBase;
import au.com.automation.pages.tripPlannerPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TripPlannerStepDef extends TestBase {
   tripPlannerPage tripPlanner = new tripPlannerPage(driver);

    org.apache.log4j.Logger log = Logger.getLogger(TripPlannerStepDef.class);

    @Given("^User navigates to Trip Planner URL$")
    public void userNavigatesToApplicationURL() throws InterruptedException {
        tripPlanner.navigateToURL();
    }
    @When("^Enter origin \"([^\"]*)\" and destination station \"([^\"]*)\"$")
    public void enterOriginAndDestinationStation(String fromLocation, String toLocation) throws Throwable {
        tripPlanner.originLocationText(fromLocation,toLocation);
    }
    @And("^User clicks Go button$")
    public void userClicksGoButton() {
        tripPlanner.clickOnGoBtn();
    }

    @Then("^User should get list of trips provided$")
    public void userShouldGetListOfTripsProvided() throws InterruptedException {
        tripPlanner.listOfTripsProvide();
    }

}
