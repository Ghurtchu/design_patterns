package structural_design_patterns.bridge

import java.security.MessageDigest

object CodeExample extends scala.App {

  // some party library
  object Hex {
    def encodeHex(obj: Object): String = ""
  }

  trait Hasher {
    def hash(data: String): String

    protected def getDigest(algorithm: String, data: String): MessageDigest = {
      val crypt = MessageDigest.getInstance(algorithm)
      crypt.reset()
      crypt.update(data.getBytes("UTF-8"))

      crypt
    }
  }

  class Sha1Hasher extends Hasher {
    override def hash(data: String): String =
      new String(Hex.encodeHex(getDigest("SHA-1", data).digest()))
  }

  class Sha256Hasher extends Hasher {
    override def hash(data: String): String =
      new String(Hex.encodeHex(getDigest("SHA-256", data).digest()))
  }

  class Md5Hasher extends Hasher {
    override def hash(data: String): String =
      new String(Hex.encodeHex(getDigest("MD5", data).digest()))
  }

  // bridge class between converted implementations and hasher implementations
  abstract class PasswordConverter(hasher: Hasher) {
    def convert(password: String): String
  }

  class SimplePasswordConverter(hasher: Hasher) extends
    PasswordConverter(hasher) {
    override def convert(password: String): String =
      hasher.hash(password)
  }
  class SaltedPasswordConverter(salt: String, hasher: Hasher) extends
    PasswordConverter(hasher) {
    override def convert(password: String): String =
      hasher.hash(s"${salt}:${password}")
  }

}
