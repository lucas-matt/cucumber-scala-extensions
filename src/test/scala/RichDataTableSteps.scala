import com.twitter.util.Eval
import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.matchers.ShouldMatchers

import cucumber.ext.CucumberImplicits.DataTable2RichDataTable

/**
 * Created with IntelliJ IDEA.
 * User: lucas
 * Date: 7/24/13
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */
class RichDataTableSteps extends ScalaDsl with EN with ShouldMatchers {

  var input:DataTable = null

  var actual:Any = null

  Given("""^I have a data table 'mytable':$"""){ (in:DataTable) =>
    input = in
  }

  When("""^I run `mytable.dup`$"""){ () =>
    actual = input.dup
  }

  When("""^I run `mytable.transpose`$"""){ () =>
    actual = input.transpose
  }

  When("""^I run `mytable.maps`$"""){ () =>
    actual = input.maps
  }

  Then("""^I should get the resulting list of maps :$"""){ (code:String) =>
    val expected = Eval[List[Map[String,String]]](code)
    actual should be(expected)
  }

  When("""^I run `mytable.rowsMap`$"""){ () =>
    actual = input.rowsMap
  }

  When("""^I run `mytable.columnNames`$"""){ () =>
    actual = input.columnNames
  }

  When("""^I run `mytable.rows`$"""){ () =>
    actual = input.rows
  }

  Then("""^I should get the resulting map :$"""){ (code:String) =>
    val expected = Eval[Map[String,String]](code)
    actual should be (expected)
  }

  Then("""^I should get the resulting list :$"""){ (code:String) =>
    val expected = Eval[List[String]](code)
    actual should be (expected)
  }

  Then("""^I should get .* table.*$"""){ (expected:DataTable) =>
    actual should be(expected)
  }

}
