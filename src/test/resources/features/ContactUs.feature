@ContactUsPage

Feature: Contact Us Functionality
   
    	Background:
    		Given start chrome browser
    		And navigate to ContactUs page
    	
    	Scenario: Enter invalid email in Contact Us form
    	    When enter all valid details and invalid email
    	    And click on send message button
    	    Then it should display invalid email error message
    	   
    	Scenario: Submit valid Contact Us form
    	    When enter all valid details
    	    And click on send message button
    	    Then it should display success message