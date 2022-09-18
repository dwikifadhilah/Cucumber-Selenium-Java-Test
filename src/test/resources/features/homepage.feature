@RunAll
@HomePage
Feature: use many feature in homepage

  Scenario: User can see booking cart by open booking cart button
    Given I navigated to homepage
    When I open my booking cart
    Then My booking cart should be open and message is "Till now you did not added any room in your cart."

  @contact
  Scenario: User can open Contact Us page after clicking 'Contact' in the navbar menu
    Given I navigated to homepage
    When I open contact
    Then I see "Contact Us" page heading

  @Navbar
  Scenario: user can close navbar on home page after opening it
    Given I navigated to homepage
    And I already open navbar
    When I close navbar
    Then I see navbar has been closed

  @SearchNowButton
  Scenario Outline: User can't press the Search Now Button if they have not filled in the <data>
    Given I navigated to homepage
    When I didn't fill in the <data> but filled in other details
    Then I should see that failed to find a room and stayed on the "Sekolah QA" page
    Examples:
      | data           |
      | Hotel Location |
      | Select Hotel   |
      | Check In Date  |
      | Check Out Date |