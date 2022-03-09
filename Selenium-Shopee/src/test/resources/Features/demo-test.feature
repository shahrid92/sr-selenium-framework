
  @TestFeature
  Feature: to test feature cucumber file

   @smoketest
   Scenario Outline: this is first scenario

      Given this is given step
      When this is when step
      And this is and step
      And this is <step>
      Then this is then step

      Examples:
      |step|
      |test step|
