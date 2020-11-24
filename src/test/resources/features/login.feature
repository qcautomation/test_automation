@tag
Feature: OLB Login screen components
  As an OLB user I want to validate all login screen components

  @tag1
  Scenario: Greeting Message
    Given I am placed on the Online Banking platform
    When I check greeting message
    Then I validate message content

