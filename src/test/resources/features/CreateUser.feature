#language:en
Feature: Validate user login with error


@emptyFields
Scenario: User without registration tries to login
  Given I'm at mybank home
  And select the remember option
  And does not inform user data
  Then displays incorrect login and password data


@incorrectData
Scenario: User without registration tries to login
  Given I'm at mybank home
  And select the remember option
  And inform the user's data usuario com dados
  Then user logs into the system


