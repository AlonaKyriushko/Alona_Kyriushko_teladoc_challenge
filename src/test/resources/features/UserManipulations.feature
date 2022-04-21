Feature: Add a remove a user

  #using Scenario Outline and Examples I added data that I can use in my implementation
  @task
  Scenario Outline: Add a user
    When user click on Add user
    And enter "<firstName>", "<lastName>","<UserName>", "<Password>","<Customer>","<Role>", "<Email>", and "<Phone>"
    And click on save
    Then user verify that "<UserName>" is added
    Examples:
      | firstName | lastName | UserName        | Password | Customer    | Role     | Email         | Phone      |
      | Alfredo   | Gonzales | alfredogonzales | XYZ123!  | Company AAA | Customer | zxc@gmail.com | 1222233212 |


  # in this case I provided direct data in scenario
  @task
  Scenario: Delete user User Name: novak
    When user search "novak"
    And click on delete user
    Then user verify that user with name "Novak" was deleted



