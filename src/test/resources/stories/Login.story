Narrative:
This Story covers basic tests of login

Scenario: Login as OCT Admin
Given I Open Login Page
When I type user phone "+111111111"
And I type password "qwerty"
And I click on Login button
Then I should see Dashboard

Scenario: Login as OCT Moderator
Given I Open Login Page
When I type user phone "+111111112"
And I type password "qwerty"
And I click on Login button
Then I should see Dashboard

Scenario: Login as OCT Content Manager
Given I Open Login Page
When I type user phone "+111111113"
And I type password "qwerty"
And I click on Login button
Then I should see Dashboard

Scenario: Go To Forgot Password Screen
Given I Open Login Page
When I Clcik on the Forgot Password Button
Then I see Forgot Password Screen



