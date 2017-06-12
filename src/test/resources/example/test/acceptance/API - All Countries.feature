@APIAcceptanceTest
Feature: Listing all countries from the API.

  As a normal API user 
  I want to be able to see all countries in the world 
  So that I can then choose which country to see further details about

  1. GET /rest/v1/all should return a complete list of all the countries of the world (250).
  2. The /rest/v1/all response should be valid against the countries JSON schema.
  3. Countries returned should adhere to known values.

  Scenario Outline: Countries returned from /rest/v1/all endpoint adhere to known values
    Given /rest/v1/all supports GET requests
    When a GET request is made to /rest/v1/all
    Then the status code returned should be 200
    And the response returned should adhere to the countries JSON schema
    And the country named "<Name>" should have the following values:
      | name   | capital   | region   | subregion   | demonym   |
      | <Name> | <Capital> | <Region> | <SubRegion> | <Demonym> |

    Examples:
      | Name           | Capital | Region | SubRegion       | Demonym |
      | United Kingdom | London  | Europe | Northern Europe | British |

  Scenario: GET to the /rest/v1/all endpoint to get all the countries of the world.
    Given /rest/v1/all supports GET requests
    When a GET request is made to /rest/v1/all
    Then the status code returned should be 200
    And the response returned should adhere to the countries JSON schema
    And there should be 250 countries returned

  Scenario: PUT to the /rest/v1/all endpoint should return a 405
    Given /rest/v1/all does not support PUT requests
    When a PUT request is made to /rest/v1/all
    Then the status code returned should be 405

  Scenario: POST to the /rest/v1/all endpoint should return a 405
    Given /rest/v1/all does not support POST requests
    When a POST request is made to /rest/v1/all
    Then the status code returned should be 405

  Scenario: DELETE to the /rest/v1/all endpoint should return a 405
    Given /rest/v1/all does not support DELETE requests
    When a DELETE request is made to /rest/v1/all
    Then the status code returned should be 405
