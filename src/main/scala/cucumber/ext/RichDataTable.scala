package cucumber.ext

import cucumber.api.DataTable

/**
 * Created with IntelliJ IDEA.
 * User: lucas
 * Date: 7/22/13
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
class RichDataTable(table:DataTable) {

  val delegate = table

  def dup:DataTable = {
    DataTable.create(delegate.raw())
  }

//  def transpose:RichDataTable = {
//    throw new UnsupportedOperationException()  }
//
//  def maps:Map[String, String] = {
//    throw new UnsupportedOperationException()
//  }
//
//  def rowsMap:Map[String, String] = {
//    throw new UnsupportedOperationException()
//  }
//
//  def raw:List[List[String]] = {
//    throw new UnsupportedOperationException()
//  }
//
//  def columnNames:List[String] = {
//    throw new UnsupportedOperationException()
//  }
//
//  def rows:Unit = {
//    throw new UnsupportedOperationException()
//  }
//
//  def eachCellsRow(fn: List => Any):List[Any] = {
//    throw new UnsupportedOperationException()
//  }
//
//  def accept(fn: List => Any):List[Any] = {
//    throw new UnsupportedOperationException()
//  }

}
