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


Scenario: maps
  Given I have a data table 'mytable':
    | a | b | sum |
    | 2 | 3 |   5 |
    | 7 | 9 |  16 |
  When I run `mytable.maps`
  Then I should get the resulting list of maps :
  """
    List(
      Map("a" -> "2", "b" -> "3", "sum" ->  "5"),
      Map("a" -> "7", "b" -> "9", "sum" -> "16"))
  """

# Converts this table into a Hash where the first column is
# used as keys and the second column is used as values
#
#   | a | 2 |
#   | b | 3 |
#
# Gets converted into the following:
#
#   {'a' => '2', 'b' => '3'}
#
# The table must be exactly two columns wide
#
Scenario: rows map
  Given I have a data table 'mytable':
    | a | 2 |
    | b | 3 |
  When I run `mytable.rowsMap`
  Then I should get the resulting map :
  """
    Map("a" -> "2", "b" -> "3")
  """

