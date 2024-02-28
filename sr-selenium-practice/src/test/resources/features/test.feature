@SmokeTest

Feature: To test orange demo website

  Scenario Outline:  User login with admin credential
    Given Users launch browser and login as "<username>" and "<password>"

  Examples:
      | username   | password |
      | Admin      | admin123 |

  @Test
  Scenario Outline:  As Admin add new employees details
    Given Users launch browser and login as "<username>" and "<password>"
    Then Navigate to PIM and click add employee
    And Fill all new employee names
      |FirstName|MiddleName|LastName|
      |John     |Wick      |Karlov  |

   Examples:
      | username   | password |
      | Admin      | admin123 |


  Scenario Outline:  As Admin create one ESS role user
    Given Users launch browser and login as "<username>" and "<password>"
    And Navigate admin page and click Add User
    Then Enter new user details and save

    Examples:
      | username   | password |
      | Admin      | admin123 |


  Scenario Outline: As ESS role user
    Given Users launch browser and login as "<username>" and "<password>"
    Then Apply leave by navigate to dashboard

    Examples:
      | username   | password |
      | Admin      | admin123 |
# last actibity
  # setup docker for oranghrm since the online already take down