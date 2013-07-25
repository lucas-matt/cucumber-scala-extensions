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

Scenario: transpose
  Given I have a data table 'mytable':
    | a | 7 | 4 |
    | b | 9 | 2 |
  When I run `mytable.transpose`
  Then I should get a transposed version of my data table, i.e.
    | a | b |
    | 7 | 9 |
    | 4 | 2 |

