package com.vidal.controlcenter.util.collections

/**
 * Date: 22/12/11
 */

trait CollectionsUtils {
   /**
    * implicit conversion from java.util.List[A] to scala.immutable.List[A] when trait CollectionUtils is Mixin
    */
    implicit def convertJavaUtilListToScalaImmutableList[A](javaList: java.util.List[A]): List[A] = {
       if(javaList == null) Nil
       else javaList.toArray.toList.map(_.asInstanceOf[A])
    }
}
