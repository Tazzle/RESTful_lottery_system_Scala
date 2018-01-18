package com.api.models

import scala.util._

class Line  {

  private val random = Random
  private val numberOfValues = 3
  private val valueRange = 3
  private var values =  Array[Int](3)
  private var outcome = 0

  {
    for (i <- 0 to numberOfValues) {
      values(i) = random.nextInt(valueRange)
    }
    calculateOutcome()
  }

  private def calculateOutcome(): Unit = {
    // _* means to pass each element as its own argument, rather than all of it as a single argument
    //https://stackoverflow.com/questions/7938585/what-does-param-mean-in-scala
    var valueSet = Set(values : _*)

   // val sum = values.reduceLeft((a:Int, b:Int) => a + b)
    if(values.reduceLeft[Int](_+_) == 2) outcome = 10
    else if (valueSet.size == 1) outcome = 5
    else if(!values(0).equals(values(1)) && !values(0).equals(values(2))) outcome = 1
    else outcome = 0
  }


   def Outcome(): Int = {
     this.outcome
   }

  def Values(): Array[Int] = {
    this.values
  }






}
