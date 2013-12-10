object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello, beans world!")

    val listOfInts = List(1,2,3,4,5,8,4)
    val listOfDoubles = List(4.5,3.6,9.5,3.1)

    mapOverDays
    println("Fold left for accumulating :" + foldLeftForAdding(listOfInts))
    println("Fold left for multiplication :" + foldLeftForMultiply(listOfInts))
    println("Count the number of items using fold left :" + foldLeftForCounting(listOfInts))
    println("Average of a double list :" + foldLeftForAverageOfDoubles(listOfDoubles))
    println("Return the Last Value using foldLeft :" + foldLeftLastValue(listOfInts))   //use .last() in real life

  }

  /*
  Map over a List
   */
  def mapOverDays = {
    val days = List("Monday", "Tuesday", "Wednesday")
    days.map(x => println(x))  // you can also use _ here
  }

  /**
   * Calculates the sum of a list using foldLeft
   */
  def foldLeftForAdding(list: List[Int]):Int = {

    def initialValue = 0

    /**
     * Initial Value is the initial value of the equation, if you place an
     * integer in here it automatically assumes all the other values are
     * integers too.
     *
     * The method begins to apply the function on each members of the list
     * referred to here by 'current' and then stores this value in the result.
     * We sometimes call the result the accumulator, since it accumulates
     * the result of the function.
     *
     * So remember the last bit here is the function ie. the result + the current, so therefore like
     * changing the function to be current * 2 will take the last item in the List and times it by 2
     *
     * In this example we can also use underscore _ can stand for the result and _ can stand for the current
     * therefore we could write it like this
     * list.foldLeft(initialValue)(_ + _)
     */
    list.foldLeft(initialValue)((result, current) => result + current)
  }

  def foldLeftForMultiply(list: List[Int]):Int = {

    /**
     * If the initial value where 0 it would always multiply by 0 and therefore the result would
     * always be 0, therefore lets change this to a 1
     */
//    list.foldLeft(1)((result, current) => result * current)
    list.foldLeft(1)(_ * _)
  }

  def foldLeftForCounting(list:List[Int]):Int = {
    //so the result needs to be result + 1
    //list.foldLeft(0)((result, current) => result + 1)
    /**
     * We call the second parameter _ here which means it can be discarded
     */
    list.foldLeft(0)((result, _) => result + 1)
  }

  def foldLeftForAverageOfDoubles(list:List[Double]):Double = {

      //first you would have to add all the double together
    //then you would have to find the amount of numbers in that list
    //lastly you would have to divide the amount of numbers in the list by all the values you added together

    //FIRST TRY
//    def accumulatedValueOfList = list.foldLeft(0.0)((result,current) => current + result)
//    def totalItemsInList = list.foldLeft(0)((result,current) => result + 1)
//    return accumulatedValueOfList / totalItemsInList

    //SECOND TRY
    def accumulatedValueOfList = list.foldLeft(0.0)(_ + _)
    def totalItemsInList = list.foldLeft(0)((result,_) => result + 1)
    return accumulatedValueOfList / totalItemsInList

  }

  def foldLeftLastValue(list:List[Int]):Int = {
    list.foldLeft(0)((_,current) => current )
  }
}
