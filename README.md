In this challenge, you will expand the previously created functionality.

This is a complex task that consists of 3 parts:
  1. Add a new UI element
  2. Modify business logic
  3. Cover new functionality with test

Part #1  
  - Add a Search field according to the design.
  - Add a "No result" item. It should be visible if the vendor's list is empty.

Part #2
  - Collect a query parameter from the Search field when a user presses on the search icon
  - Extend UI and business logic to perform getVendors() call with a collected query parameter
  - Use a query to filter data from the ApiVedors by the company_name field
  - Nice to have: start search automatically after a user has typed 3 symbols with 0.5s debouncing

Part #3

Cover the getVendors() method in the VendorsVM by Unit Tests for the following cases:   
  - Data was loaded successfully and the list contains at least one item
  - Data loaded with error

Cover the VendorsScreen by Integration (UI) Tests for the following cases:
  - "No result" item visible if the vendor's list is empty
  -  At least one item in the vendor's list is displayed if the vendor's list is not empty

[Design Link](https://www.figma.com/file/Yx4G4KSbcZTev1lRnc69sf/Task-Middle-Android?node-id=0%3A1)