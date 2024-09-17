Feature: Admin user management on OrangeHRM

  Scenario: Add and delete user
    Given I am on the OrangeHRM login page
    When I enter username "Admin" and password "admin123"
    And I click on the login button
    When I am on the Admin page
    Then I capture the current number of records
    When I click on the "Add" button and create a new user with username "newuser"
    Then the number of records should increase by 1
    When I search for the user "newuser"
    And I delete the user
    Then the number of records should decrease by 1


