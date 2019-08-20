Feature: Employee Test

  Background: Running Application
    Given url 'http://localhost:8080'

  Scenario: Testing employee GET service
  Given path 'employee/1'
  When method GET
  Then status 200
  And match $ contains {"empId":"#notnull","firstName":"James","lastName":"Helms","role":"Engineer"}

  Scenario: Testing invalid employee GET service
    Given path 'employee/3'
    When method GET
    Then status 404