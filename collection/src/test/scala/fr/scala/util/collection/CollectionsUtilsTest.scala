package fr.scala.util.collection

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import java.util.Arrays
import java.util.ArrayList

/**
 * Date: 22/12/11
 */

class CollectionsUtilsTest extends FunSuite with ShouldMatchers with CollectionsUtils {

	test("should convert java.util.List[A] to scala.immutable.List[A]") {
		val scalaList = convertJavaUtilListToScalaImmutableList(Arrays.asList("one", "two", "three"))
		scalaList.isInstanceOf[List[String]] should be(true)
		scalaList should be(List("one", "two", "three"))
	}

	test("with null input should return Nil") {
		convertJavaUtilListToScalaImmutableList(null) should be(Nil)
	}

	test("with empty list should return Nil") {
		convertJavaUtilListToScalaImmutableList(new ArrayList()) should be(Nil)
	}

}
