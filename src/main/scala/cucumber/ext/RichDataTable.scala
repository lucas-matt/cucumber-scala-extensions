package cucumber.ext

import java.util.{Map ⇒ JMap, List ⇒ JList}
import cucumber.api.DataTable
import scala.collection.JavaConversions._

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

  def transpose:DataTable = {
    val transposed:JList[JList[String]] = bufferAsJavaList(delegate.raw().transpose.map(bufferAsJavaList(_)))
    DataTable.create(transposed)
  }

  def maps:List[Map[String, String]] = {
    delegate.asMaps().map(_.toMap).toList
  }

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
