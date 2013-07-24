Feature: Rich Data Table
  As a developer
  I want a data table api like the cucumber-ruby one
  To make development easier

Scenario: dup
  Given I have a data table 'mytable':
    | A | B |
    | 1 | 2 |
  When I run `mytable.dup`
  Then I should get an exact copy of the table
    | A | B |
    | 1 | 2 |

