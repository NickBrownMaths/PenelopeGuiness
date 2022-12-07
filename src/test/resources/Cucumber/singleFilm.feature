Feature: Get a specific film

  Scenario Outline: getting a specific film from the db.
    Given a film exists with id <filmid>
    When I request that films details
    Then The webpage should show the films "<title>"
    Examples:
      | filmid | title            |
      | 1      | ACADEMY DINOSAUR |
      | 21     | AMERICAN CIRCUS  |
      | 915    | TRUMAN CRAZY     |

