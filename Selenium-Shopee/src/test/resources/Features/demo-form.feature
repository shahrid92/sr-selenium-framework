
  # Practice Test Demosqa.com

    Feature: New student form feature

     Scenario Outline: User complete registration form

       Given user at student registration form page
       When user enter <firstname>
       And user enter <lastname>
       And user enter <email>
       Then user select <gender>
       And enter <mobileNumber>
       And enter <dateOfBirth>
       And enter <subject>
       And select <hobbies>
       And enter <currentAddress>
       And select <state>
       And select <city>
       Then user click submit button

       Examples:
       |firstname|lastname|email|gender|mobileNumber|dateOfBirth|subject|hobbies|currentAddress|state|city|
       |John     |Toretto |jt@gmail.com|Male|01692819281|24 Feb 1992|Cloud Testing|test|Kuala Lumpur|Selangor|Gombak|

