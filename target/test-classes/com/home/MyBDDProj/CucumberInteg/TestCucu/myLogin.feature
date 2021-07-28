@tag 
Feature: Title of your feature 
	I want to use this template for my feature file

@tag1 
Scenario: Title of your scenario 
	Given I want to write a step with "precondition" 
	And some other precondition 
	When I complete action 
	And some other action 
	And yet another action 
	Then I validate the outcomes 
	And check more outcomes 
	
@tag2 
Scenario Outline: Title of your scenario outline 
	Given I want to write a step with <name> 
	When I check for the <value> in step 
	And When I am with "Superman" 
	Then I verify the <status> in step 
	
	Examples: 
		| name  | value | status  |
		| name1 |     vivovalone | success |
		| name2 |     vivovalseven | Fail    |
