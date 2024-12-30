@SmokeTest

Feature: To test orange demo website

  @Sanity-1
  Scenario Outline:  User login with admin credential
    Given Users launch browser and login as "<username>" and "<password>"

    Examples:
      | username | password |
      | Admin    | admin123 |

  Scenario Outline:  As Admin create new employees details and credentials
    Given Users launch browser and login as "<username>" and "<password>"
    Then Navigate to PIM and click add employee
    And Fill all new employee names
    And Navigate admin page and click Add User
    Then Enter new user details and save
    And Enter new created username search text-field

    Examples:
      | username | password |
      | Admin    | admin123 |

  @Test
  Scenario Outline: As Admin search employee with role
    Given Users launch browser and login as "<username>" and "<password>"
    Then Navigate to "Admin" page
    And Select user role "Admin"
    And Search employee username and validate user exists
      | employee_username |
      | Admin             |

    Examples:
      | username | password |
      | Admin    | admin123 |

  @Test
  Scenario Outline: As Admin can navigate admin subppage
    Given Users launch browser and login as "<username>" and "<password>"
    Then Navigate to "Admin" page
    And Navigate subpage and verify page titles
      | Path                  | Title             |
      | Job/Job Titles        | Job Titles        |
      | Job/Pay Grades        | Pay Grades        |
      | Job/Employment Status | Employment Status |
      | Job/Categories        | Job Categories    |
      | Job/Work Shifts       | Work Shifts       |


    Examples:
      | username | password |
      | Admin    | admin123 |

  Scenario Outline:  As Admin create new employees details and credentials
    Given Users launch browser and login as "<username>" and "<password>"
    Then Navigate to "PIM" page
    And Search this employee name
      | James  Butler |
    Then Click user for edit

    Examples:
      | username | password |
      | Admin    | admin123 |

  Scenario Outline: as Admin able to create summary employee report
    Given Users launch browser and login as "<username>" and "<password>"
    When admin user at "Reports" page
    Then admin fill report name as "Test Report"
    And add selection criteria as below
      | Select1           | Select2       |
      | Employee Name     | Ranga Akunuri   |
      | Employment Status | Freelance     |
      | Pay Grade         | Grade 1       |
    And select display fields as below
      | Field Group     | Display Field |
      | Personal        | Employee Id   |
      | Contact Details | Mobile        |
    Then Verify new report title name is "Test Report"

#    And select the displayed fields
#      |Displayed Field Group|Displayed Field|
#    Then the admin should able to see generated report



    Examples:
      | username | password |
      | Admin    | admin123 |
  # recruitment add candidate
  # admin job paygrade
  # employment stats
  # job catergories
  # apply leave
  # submit claim

  #TODO - create BDD first then scripting



#TODO - setup docker for orangehrm
#TODO - Add new test cases