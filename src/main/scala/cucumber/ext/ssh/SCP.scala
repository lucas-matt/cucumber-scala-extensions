package cucumber.ext.ssh

import net.schmizz.sshj.xfer.FileSystemFile
import cucumber.ext.ssh.Factory.login

case class SCPException(cause:Throwable) extends Exception

/**
 * Example :
 *
 *    val scp = new SCP(h,y,p,hs)
 *    scp(file_a, file_b)
 *
 * @param host - host of server
 * @param user - user of server to connect
 * @param pass - password
 * @param hostKeys - ssh keys if required
 */
class SCP(host:String, user:String, pass:String, hostKeys:Array[String]) {

  def apply(src:String, dest:String) {
    try {
      val ssh = login(host, user, pass, hostKeys)
      println(s"$src being sent to $dest")
      try {
        ssh.useCompression()
        ssh.newSCPFileTransfer().upload(new FileSystemFile(src), dest)
      } finally {
        ssh.disconnect()
      }
    } catch {
      case e:Exception => throw new SCPException(e)
    }
  }

}
