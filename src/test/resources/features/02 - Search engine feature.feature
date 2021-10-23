@all @searchEngine
Feature: Search engine feature

	Scenario Outline: Search engine feature of an existing Wikipedia article
		Given the Wikipedia main page (english)
		When the user introduces a <name> into the search field
		And clicks on the search button
		Then the application brings the user to the specific searched page


		Examples: 
		| name							|
		| Jimi Hendrix			|
		| Slash (musician)	|
		| John Frusciante		|
