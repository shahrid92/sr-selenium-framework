
  Feature:  Test multiple scenario with background

    Background:This is background
      Given User visit homepage

      Scenario: User fill full name textfield
        Given User enter full name
        Then User click submit button

      Scenario: User fill email textfield
        Given User enter email
        Then User click submit button