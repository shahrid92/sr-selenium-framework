
  # Practice Test Demosqa.com

    Feature: New student form feature

     Scenario Outline: User complete registration form

       Given user at student registration form page
       When user enter "<firstname>" in firstname field
       And user enter "<lastname>" in last name field
       And user enter "<email>" in email field
       Then user select "<gender>" in gender radio button
       And enter "<mobileNumber>" in mobile number field
       And enter "<dateOfBirth>" in date of birth field
       And enter "<subject>" in subject field
       Then select "<hobbies>" in hobbies radio button
       And enter "<currentAddress>" in address field
       And select "<state>" in state field
       And select "<city>" in city field
       Then user click submit button

       Examples:
       |firstname|lastname|email|gender|mobileNumber|dateOfBirth|subject|hobbies|currentAddress|state|city|
       |John     |Toretto |jt@gmail.com|Male|01692819281|24 Feb 2021|Maths|test|Kuala Lumpur|NCR|Delhi|

