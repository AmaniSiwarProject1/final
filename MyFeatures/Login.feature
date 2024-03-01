Feature: Log In

Scenario: Admin Login with correct email and password
    When admin enters email "<aya@example.com>" and password "<789>"
    Then Show admin page and success message

Scenario: Admin login wrong email
    When admin enters email "<ahmad@example.com>" and password "<789>"
    Then Show error message.

Scenario: Admin login wrong password
    When admin enters email "<aya@example.com>" and password "<123>"
    Then Show error message.

Scenario: User Login with correct email and password
    When User enters email "<rama@example.com>" and password "<125>"
    Then Show User page and success message

Scenario: User Login with wrong email
    When User enters email "<lara@example.com>" and password "<125>"
    Then Show not correct email message

Scenario: User login wrong password
    When User enters email "<rama@example.com>" and password "<258>"
    Then Show error message.

Scenario: ServiceProvider Login with correct email and password
    When ServiceProvider enters email "<rahaf@example.com>" and password "<564>"
    Then Show ServiceProvider page and success message

Scenario: ServiceProvider Login with wrong email
    When ServiceProvider enters email "<loaa@example.com>" and password "<564>"
    Then Show error message.

Scenario: ServiceProvider login wrong password
    When ServiceProvider enters email "<rahaf@example.com>" and password "<578>"
    Then Show error message.
