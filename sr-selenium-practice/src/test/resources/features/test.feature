@SmokeTest

Feature: To test orange demo website

  Scenario Outline:  User login with admin credential
    Given Users launch browser and login as "<username>" and "<password>"

  Examples:
      | username   | password |
      | Admin      | admin123 |

  Scenario Outline:  As Admin create new employees details and credentials
    Given Users launch browser and login as "<username>" and "<password>"
    Then Navigate to PIM and click add employee
    And Fill all new employee names
    And Navigate admin page and click Add User
    Then Enter new user details and save
    And Enter new created username search text-field

   Examples:
      | username   | password |
      | Admin      | admin123 |

  @Test
  Scenario Outline: As Admin delete employees details and credentials
    Given Users launch browser and login as "<username>" and "<password>"
    Then Navigate to "Admin" page
    And Search employee username and validate user exists
          |employee_username|
          |Admin        |

  Examples:
    | username   | password |
    | Admin      | admin123 |

  @Draft
  Scenario: 

  #TODO - create BDD first then scripting



#TODO - setup docker for orangehrm
#TODO - Add new test cases