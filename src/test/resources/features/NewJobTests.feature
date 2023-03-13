Feature: Test "New Job" functionality

  @hcp
  Scenario: Add "New Job" happy path
    Given Login page is opened
    When I login with username "wojciech.pulawski@gmail.com" and password "Test1234!"
    And I open new job page
    And I open new customer form
    And I set customer "Contact Info"
      | firstName | lastName | mobilePhone | company    | displayName | homePhone  | jobTitle    | email           | workPhone  |
      | John      | Brown    | 8889080980  | JB company | JBC DN      | 8889080981 | electrician | jb990@gmail.com | 8889080982 |
    And I set customer "Address"
      | street     | unit      | city     | state | zip    | addressNotes       |
      | Market Ave | test unit | New York | NY    | 798798 | address notes test |
    And I set customer "Notes"
      | customerNotes       | thisCustomerBillsTo | customerTags | leadSource |
      | Test customer notes | Jan Nowak           | testTag      | Saturday   |
    And I click "CREATE CUSTOMER" button
    Then Customer was saved correctly with following data
      | JBC DN              |
      | (888) 908-0980      |
      | jb990@gmail.com     |
      | Market Ave          |
      | New York, NY 798798 |
      | address notes test  |
    When I add new "Line item"
      | name                           | qty  | unitPrice | description               | unitCost |
      | electrical network maintenance | 3.00 | 231.00    | new line item description | 3.50     |
    Then "Line items" total amount equals "693.00"
    When I add "test private note" "Private note"
    Then "Private note" "test private note" was added correctly
    When I click "SAVE JOB" button
    Then Created job has following data in "Activity feed section"
      | Dispatched to Jan Nowak               |
      | total = $693.00                       |
      | electrical network maintenance$693.00 |