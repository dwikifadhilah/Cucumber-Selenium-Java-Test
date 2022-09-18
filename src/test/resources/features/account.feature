@RunAll
@Account
Feature: User Account
  User can manage personal information and orders

  Background: for login page
    Given I navigated to homepage
    And I login with existing account

  @Address
  Scenario: User can add address
    Given I already in "My account - Sekolah QA" page
    When I click MY ADDRESSES
    And I add a new address
    Then I should see my address has been added

  @Order
  Scenario: User can see order history and details
    Given I already in "My account - Sekolah QA" page
    When I select Order History and Details
    Then I should see order history page with page heading "ORDER HISTORY"

  @Credit
  Scenario: User can see credit slips
    Given I already in "My account - Sekolah QA" page
    When I select My Credit Slips
    Then I should see credit slips page with page heading "CREDIT SLIPS"

  @Info
  Scenario Outline: User can change personal information
    Given I already in "My account - Sekolah QA" page
    When I select My Personal Information
    And I edit my last name
    And I input <condition> credentials with a <password>
    Then I should get message <status>
    Examples:
      | condition | password    | status                                                   |
      | invalid   | passsalah   | The password you entered is incorrect.                   |
      | valid     | punya.dwiki | Your personal information has been successfully updated. |

  @changeName
  Scenario Outline: User can't use numbers in name field
    Given I already in "My account - Sekolah QA" page
    When I select My Personal Information
    And I change <name> using number <number>
    Then I should get error message <error>
    Examples:
      | name       | number | error                 |
      | first name | 12345  | firstname is invalid. |
      | last name  | 67890  | lastname is invalid.  |
