@RunAll
@Booking
Feature: Success Booking

  @BookingWithoutLogin
  Scenario Outline: User can book hotel room with multiple payment methods without login
    Given I navigated to homepage
    When I choose hotel and choose a booking date
    And I choose a <rooms>
    And I followed the order step and signup
    And I select <payment> payment method
    Then I should see the booking status <message>
    And I should see total amount include tax is <amounts>
    Examples:
      | rooms           | payment   | message                               | amounts         |
      | General Rooms   | Bank Wire | Your order on Sekolah QA is complete. | $1,040.00       |
      | Executive rooms | Check     | Your order on Sekolah QA is complete. | $2,080.00       |
      | Luxury Rooms    | Paypal    | Please try to contact the merchant:   | Error occurred: |

  @BookingAfterLogin
  Scenario Outline: User can book hotel room with multiple payment methods after login
    Given I navigated to homepage
    When I login with existing account
    And I back to homepage after login
    And I choose hotel and choose a booking date
    And I choose a <rooms>
    And I followed the order step
    And I select <payment> payment method
    Then I should see the booking status <message>
    And I should see total amount include tax is <amounts>
    Examples:
      | rooms           | payment   | message                               | amounts         |
      | General Rooms   | Bank Wire | Your order on Sekolah QA is complete. | $1,000.00       |
      | Executive rooms | Check     | Your order on Sekolah QA is complete. | $2,000.00       |
      | Luxury Rooms    | Paypal    | Please try to contact the merchant:   | Error occurred: |
