@BookingPage

Feature: Booking Functionality
  
  	Background:
    		Given start the chrome browser
    		And navigate to Booking page
    
  	Scenario: submit Booking form with all fields blank
  	   When enter all fields blank
  	   And click on book now button
  	   Then it should display error message below all fields 
  	  
    Scenario: Enter invalid email in Email ID field
       When enter valid details in all fields and invalid email
       And click on book now button
       Then should display invalid email error message  
      
    Scenario: Enter non numeric phone number
       When enter valid details in all fields and non numeric phone number
       And click on book now button
       Then should display invalid phoneno error message
     
    Scenario: Submit valid booking details
       When enter all valid details to book
       And click on book now button
       Then should display success message