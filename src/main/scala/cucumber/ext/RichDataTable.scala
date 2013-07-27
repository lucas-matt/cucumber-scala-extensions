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

  def rowsMap:Map[String, String] = {
    val tuples= delegate.raw().map { l:JList[String] =>
      l.toArray match {
        case Array(k:String,v:String) => (k,v)
        case  _ => throw new IllegalArgumentException("Can only use '#rowsMap' on DataTable with rows width = 2")
      }
    }
    Map(tuples: _*)
  }


  def columnNames:List[String] = {
    delegate.topCells().toList
  }

  def rows:List[List[String]] = {
    delegate.raw.tail.map(_.toList).toList
  }

  def forEachRow(fn: List[String] => Unit): Unit = {
    rows.foreach(fn)
  }

//
//  def eachCellsRow(fn: List => Any):List[Any] = {
//    throw new UnsupportedOperationException()
//  }
//
//  def accept(fn: List => Any):List[Any] = {
//    throw new UnsupportedOperationException()
//  }

}
