package maak.leetcode.problems.algorithms

class M_468_ValidateIPAddressTest extends org.scalatest.FlatSpec {
  import M_468_ValidateIPAddress._

  "validIPAddress" should "IPv4 for input 172.16.254.1" in {
    assert(validIPAddress("172.16.254.1") == "IPv4")
  }

  "validIPAddress" should "IPv6 for input 2001:0db8:85a3:0:0:8A2E:0370:7334" in {
    assert(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334") == "IPv6")
  }

  "validIPAddress" should "Neither for input 256.256.256.256" in {
    assert(validIPAddress("256.256.256.256") == "Neither")
  }

  "validIPAddress" should "Neither for input 172.16.254.01" in {
    assert(validIPAddress("172.16.254.01") == "Neither")
  }

  "validIPAddress" should "Neither for input 2001:0db8:85a3::8A2E:0370:7334" in {
    assert(validIPAddress("2001:0db8:85a3::8A2E:0370:7334") == "Neither")
  }

  "validIPAddress" should "IPv6 for input 2001:0db8:85a3:0000:0:8A2E:0370:733a" in {
    assert(validIPAddress("2001:0db8:85a3:0000:0:8A2E:0370:733a") == "IPv6")
  }

  "validIPAddress" should "Neither for input 02001:0db8:85a3:0000:0000:8a2e:0370:7334" in {
    assert(validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334") == "Neither")
  }
}
