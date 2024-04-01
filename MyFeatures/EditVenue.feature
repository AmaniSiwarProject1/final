Feature: Edit Venue Details

 Scenario: Venue Not Found
    Given The user wants to update a venue and The venue does not exist in the venues list
    When The user provides the new venue details
    Then The system displays a message that the venue was not found
    
 Scenario: Update Venue Details
Given The user wants to update a venue
When The user provides the new venue details
Then The system updates the venue details 

Scenario: Update Venue Capacity
Given The user wants to update the capacity of a venue
When The user provides the new capacity for the venue
Then The system updates the venue capacity and The system confirms that the capacity has been updated successfully 

Scenario: Update Venue Location
Given The user wants to update the location of a venue
When The user provides the new location for the venue
Then The system updates the venue location  and The system confirms that the location has been updated successfully 

Scenario: Update venue Pricing
Given The user wants to update the pricing options for a venue
When The user provides the new pricing details for the venue
Then The system updates the pricing options and The system confirms that the pricing options have been updated successfully