@TripPlanner
Feature: Navigate to TripPlanner Application and Fill the origin and destination

  Scenario: User redirect to Application and perform the required action
    Given User navigates to Trip Planner URL
    When Enter origin "North Sydney Station" and destination station "Town Hall Station"
    And User clicks Go button
    Then User should get list of trips provided



