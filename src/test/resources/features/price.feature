@RunAll
@Price
Feature: Filter price

  Background:
    Given I navigated to homepage
    When I choose hotel and choose a booking date

  @Slider
  Scenario: User can filter hotel room price using slider
    Given I already in "The Hotel Prime - Sekolah QA" page
    When I filter the prices using a slider with a price range between $1000 to $1889
    Then I see that the max price becomes "$ 1889"
    And I should see that hotel rooms with prices over $1889 are not shown

  @SortBy
  Scenario: User can sort hotel room prices starting with the most expensive
    Given I already in "The Hotel Prime - Sekolah QA" page
    When I sort price by Highest First
    Then I should see that the first room with price "$2,500.00"