package structural_design_patterns.bridge

import structural_design_patterns.bridge.CodeExample.{Hasher, Hex}

object ScalaWay extends scala.App {

  // we can use self types here

  trait Sha1Hasher extends Hasher {
    override def hash(data: String): String =
      new String(Hex.encodeHex(getDigest("SHA-1", data).digest()))
  }

  trait Sha256Hasher extends Hasher {
    override def hash(data: String): String =
      new String(Hex.encodeHex(getDigest("SHA-256", data).digest()))
  }

  trait Md5Hasher extends Hasher {
    override def hash(data: String): String =
      new String(Hex.encodeHex(getDigest("MD5", data).digest()))
  }

  // concrete instance of PasswordConverterBase needs Hasher instance to do its job
  // so while creating a concrete instance we must supply the concrete impl of Hasher
  abstract class PasswordConverterBase { self: Hasher =>
    def convert(password: String): String
  }

  class SimplePasswordConverterScala extends PasswordConverterBase { self: Hasher =>
    override def convert(password: String): String = hash(password)
  }

  class SaltedPasswordConverterScala(salt: String) extends PasswordConverterBase { self: Hasher =>
    override def convert(password: String): String =
      hash(s"${salt}:${password}")
  }

  // when creating concrete instances of PasswordConverterBase
  // we must mix in with it the concrete trait of Hasher
  // see examples below:

  val p1 = new SimplePasswordConverterScala with Sha1Hasher
  val p2 = new SimplePasswordConverterScala with Md5Hasher


}
