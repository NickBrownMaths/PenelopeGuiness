Feature: Get a specific actor
  Scenario Outline: getting a specific actor from the db.
    Given an actor exists with id <actorID>
    When I request that actors details
    Then The webpage should show the actors "<firstname>" and "<lastname>"
    Examples:
      | actorID | firstname | lastname     |
      | 1       | PENELOPE  | GUINESS      |
      | 5       | JOHNNY    | LOLLOBRIGIDA |