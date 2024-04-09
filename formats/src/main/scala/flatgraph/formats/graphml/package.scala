package flatgraph.formats

package object graphml {
  // we could/should make these configurable...
  val KeyForNodeLabel = "labelV"
  val KeyForEdgeLabel = "labelE"

  object Type extends Enumeration {
    val Boolean = Value("boolean")
    val Int     = Value("int")
    val Long    = Value("long")
    val Float   = Value("float")
    val Double  = Value("double")
    val String  = Value("string")

    def fromRuntimeClass(clazz: Class[?]): Type.Value = {
      if (clazz == classOf[Boolean] || clazz == classOf[java.lang.Boolean])
        Type.Boolean
      else if (clazz == classOf[Int] || clazz == classOf[Integer])
        Type.Int
      else if (clazz == classOf[Long] || clazz == classOf[java.lang.Long])
        Type.Long
      else if (clazz == classOf[Float] || clazz == classOf[java.lang.Float])
        Type.Float
      else if (clazz == classOf[Double] || clazz == classOf[java.lang.Double])
        Type.Double
      else if (clazz == classOf[String])
        Type.String
      else
        throw new AssertionError(s"unsupported runtime class `$clazz` - only ${Type.values.mkString("|")} are supported...}")
    }
  }

  private[graphml] case class PropertyContext(name: String, tpe: Type.Value)

}
