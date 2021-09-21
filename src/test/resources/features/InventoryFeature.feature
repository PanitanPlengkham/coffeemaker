Feature: Adding things to inventory .

  Scenario: Check stock for inventory
    Given I check stock for inventory
    Then 15 coffee, 15 milk, 15 sugar, 15 chocolate

  Scenario: Adding chocolate to inventory
    Given I check stock for inventory
    When I adding chocolate 15
    Then 15 coffee, 15 milk, 15 sugar, 30 chocolate is filled

  Scenario: Adding milk to inventory
    Given I check stock for inventory
    When I adding milk 15
    Then 15 coffee, 30 milk, 15 sugar, 15 chocolate is filled

  Scenario: Adding sugar to inventory
    Given I check stock for inventory
    When I adding sugar 15
    Then 15 coffee, 15 milk, 30 sugar, 15 chocolate is filled

  Scenario: Adding coffee to inventory
    Given I check stock for inventory
    When I adding coffee 15
    Then 30 coffee, 15 milk, 15 sugar, 15 chocolate is filled




