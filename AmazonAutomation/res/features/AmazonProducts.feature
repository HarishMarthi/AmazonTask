Feature: Amazon Products Search and Verify

  Scenario Outline: Print third phone title in amazon application
    Given User land on Home page of amazon application
    Then verify page title contains <amzonTitle> on the amazon application
    When verify that header bar got displayed in amazon home page
    And user enter search product name as <productName> in the search bar
    And print the name and title of the third phone from the results

    Examples: 
      | amzonTitle | productName |
      | Amazon.com | phone       |

  Scenario Outline: Print product rating stars avg rating value from the selected product
    Given User land on Home page of amazon application
    When verify page title contains <amzonTitle> on the amazon application
    Then user enter search product name as <productName> in the search bar
    And user click on the third phone from the search results
    And verify that user is landed on product details page
    And user hover the rating stars in product details section
    And read and print the avg stars rate from the product details section

    Examples: 
      | amzonTitle | productName |
      | Amazon.com | phone       |

  Scenario Outline: Validate pin code change flow im amaz
    Given User land on Home page of amazon application
    When verify page title contains <amzonTitle> on the amazon application
    Then user click on change address button in the pop up
    And verify that choose location pop up dispayed in home page
    And user enter new zip code as <zipCode> in popup
    And user click on apply button in choose location popup
    And user click on continue button in another pop up
    And user click on delivery to location icon in home page
    And verify that choose location pop up dispayed in home page
    And In the pop up which open click on change button
    And user selects deliver country as <newDeliveryCountry> from country list
    And user clear existing zipcode and enter new zip code as <newZipCode> in popup
    And user click on done button in bottom of the popup
    And verify that user land on homepage with new delivery address as <newDeliveryCountry>

    Examples: 
      | amzonTitle | zipCode | newZipCode | newDeliveryCountry |
      | Amazon.com |   94611 |      60306 | Germany            |
