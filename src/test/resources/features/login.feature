@RunAll
@Login
Feature: login and signup

  Scenario Outline: User Login using credentials account
    Given I navigated to homepage
    And I login with credentials <email> and <password>
    Then I could see that <status> is showing
    Examples:
      | email                 | password      | status                  |
      | punya.dwiki@gmail.com | passwordSalah | Authentication failed.  |
      | punya.dwiki@gmail.com | punya.dwiki   | My account - Sekolah QA |

  @signup
  Scenario Outline: User can create an account using email
    Given I navigated to homepage
    And I sign up using <email>
    Then I should see that signup <status> is displayed
    Examples:
      | email                      | status                    |
      | .emailsalah@gmail.com      | Invalid email address.    |
      | contohemailbenar@gmail.com | YOUR PERSONAL INFORMATION |

