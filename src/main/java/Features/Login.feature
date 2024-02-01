Feature: Validate login feature

Background:
Given User is in sigin page

	@sanity @login
  Scenario Outline: Login with valid
  When User enters valid "<username>" and "<password>"
  Then User should land on homepage
  
Examples:
	|username     |password |
	|mithun@ta.com|mithun123|
	|deek@ta.com  | Deek123 |
  
  @regression @login
  Scenario: Login with invalid
  When User enters invalid username and password
  Then User should see error messages
  
  @regression @login
  Scenario: check scores
  When User enters invalid username and password
  Then User should see scores
  |scores| names |
  |100| rohit |
  |200| jadeja |
  |150| virat|
  |220| sachin |
  
  