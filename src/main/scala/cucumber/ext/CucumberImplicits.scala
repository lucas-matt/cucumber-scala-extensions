package cucumber.ext

import cucumber.api.DataTable

/**
 * Created with IntelliJ IDEA.
 * User: lucas
 * Date: 7/22/13
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
object CucumberImplicits {

  implicit def DataTable2RichDataTable(table:DataTable) = new RichDataTable(table)

}
