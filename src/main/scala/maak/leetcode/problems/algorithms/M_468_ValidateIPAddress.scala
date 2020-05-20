package maak.leetcode.problems.algorithms

/*
Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
Constraint: leading zeros is invalid. For example, the address 172.16.254.01 is invalid. i.e. it makes the
built in Java function invalid.
 */
object M_468_ValidateIPAddress {

  val ipv4Chunk = """([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"""
  val ipv6Chunk = """([0-9a-fA-F]{1,4})"""

  val ipv4 = ("""^(""" + ipv4Chunk + """\.){3}""" + ipv4Chunk + "$").r
  val ipv6 = ("""^(""" + ipv6Chunk + """:){7}""" + ipv6Chunk + "$").r

  def validIPAddress(IP: String): String =  IP match {
    case ipv4(_*) => "IPv4"
    case ipv6(_*) => "IPv6"
    case _ => "Neither"
  }
}
