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

Scenario: rows map
  Given I have a data table 'mytable':
    | a | 2 |
    | b | 3 |
  When I run `mytable.rowsMap`
  Then I should get the resulting map :
  """
    Map("a" -> "2", "b" -> "3")
  """

Scenario: column names
  Given I have a data table 'mytable':
    | a | b | c |
    | 1 | 2 | 3 |
  When I run `mytable.columnNames`
  Then I should get the resulting list :
  """
    List("a", "b", "c")
  """

Scenario: rows
  Given I have a data table 'mytable':
    | a | b | c |
    | 1 | 2 | 3 |
    | 4 | 5 | 6 |
    | 7 | 8 | 9 |
  When I run `mytable.rows`
  Then I should get the resulting list :
  """
    List(
      List("1", "2", "3"),
      List("4", "5", "6"),
      List("7", "8", "9"))
  """

