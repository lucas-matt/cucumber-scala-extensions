package cucumber.ext.ssh

import java.util.concurrent.TimeUnit
import net.schmizz.sshj.connection.channel.direct.Session
import net.schmizz.sshj.connection.channel.direct.Session.Command
import net.schmizz.sshj.common.IOUtils
import cucumber.ext.ssh.Factory.login

case class SSHException(cause:Throwable) extends Exception

/**
 * Example :
 *
 *    val ssh = new SSH(h,y,p,hs)(timeout=1000)(_)
 *    ssh {
 *      "ls -l"
 *    }
 *
 * @param host - host of server
 * @param user - user of server to connect
 * @param pass - password
 * @param hostKeys - ssh keys if required
 */
class SSH(host:String, user:String, pass:String, hostKeys:Array[String]) {

  def apply(timeout:Int = 10000)(cmd: String):String = {
    try {
      val ssh = login(host, user, pass, hostKeys)
      try {
        println(cmd)
        val session: Session = ssh.startSession()
        try {
          val exec: Command = session.exec(cmd)
          val result = IOUtils.readFully(exec.getInputStream).toString
          exec.join(5, TimeUnit.SECONDS)
          return result
        } finally {
          session.close()
        }
      } finally {
        ssh.disconnect()
      }
    } catch {
      case e:Exception => throw new SSHException(e)
    }

  }

}








