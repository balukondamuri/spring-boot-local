Feature: Employee Test

  Background: Running Application
    Given url 'http://localhost:8080'

  Scenario: Should return employee details when request for valid employee
    Given path 'employee/1'
    When method GET
    Then status 200
    And match $ contains {"empId":"#notnull","firstName":"James","lastName":"Helms","role":"Engineer"}

  Scenario: Should return 404 error when request for invalid employee
    Given path 'employee/3'
    When method GET
    Then status 404

  Scenario: New employee should be added
    Given path 'employee/add'
    And request {firstName:"testFirst",lastName:"testLast",role:"Sr Engineer"}
    When method POST
    Then status 200
    And match $ contains {"empId":"#notnull"}