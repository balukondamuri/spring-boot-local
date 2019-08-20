Feature: Employee Test

  Background: Running Application
    Given url 'http://localhost:8080'

  Scenario: should return employee details when request for valid employee id
    Given path 'employee/1'
    When method GET
    Then status 200
    And match $ contains {"empId":"#notnull","firstName":"James","lastName":"Helms","role":"Engineer"}

  Scenario: should return 404 error when request for invalid employee
    Given path 'employee/3'
    When method GET
    Then status 404

  Scenario: should return employee details when request for valid employee name
    Given path 'employee/firstName/James'
    When method GET
    Then status 200
    And match $ contains {"empId":"#notnull","firstName":"James","lastName":"Helms","role":"Engineer"}

  Scenario: should return 404 error when request for invalid employee name
    Given path 'employee/firstName/James1'
    When method GET
    Then status 404
    And match $ contains "Unable to find employee with firstName James1"
    
  Scenario: new employee should be added
    Given path 'employee/add'
    And request {firstName:"testFirst",lastName:"testLast",role:"Sr Engineer"}
    When method POST
    Then status 200
    And match $ contains {"empId":"#notnull"}

  Scenario: should return null when trying to add empty employee payload
    Given path 'employee/add'
    And request {}
    When method POST
    Then status 404
    And match $ contains null
