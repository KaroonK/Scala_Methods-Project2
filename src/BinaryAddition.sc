import scala.collection.immutable.Nil

// COSC 455 - Programming Languages: Implementation and Design
// Project 2

// NAME: Karoon Khatiwada

// This function does the binary addition of two Booleans and a carry bit.
def addBits(pBit: Boolean, qBit: Boolean, carryBit: Boolean): Boolean = {
  ((pBit ^ qBit) ^ carryBit)
}


// This function does the binary addition when there are uneven lists and still must
// finish the add with the carry bits.
def finishBinaryAdd(remainingBits: List[Boolean], carryBit: Boolean): List[Boolean] = remainingBits match{
  case head::tail => {
    head match {
      case _ if(carryBit) => !head::finishBinaryAdd(tail, head)
      case _ if(!carryBit) => remainingBits
    }
  }
  case Nil => {
    carryBit match {
      case true => List(true)
      case false => Nil
    }
  }

}

// This function does the binary addition of two boolean lists. Note that the lists may not be equal in length.
def doBinaryAddition(pBits: List[Boolean], qBits: List[Boolean], carryBit: Boolean): List[Boolean] = {
  if(small(pBits,qBits).isEmpty){finishBinaryAdd(big(pBits,qBits), carryBit)}
  else {addBits(pBits.head, qBits.head, carryBit) ::doBinaryAddition(pBits.tail, qBits.tail, getNextCarryBit(pBits.head, qBits.head, carryBit)) }

}
def small(pList:List[Boolean],qList:List[Boolean]) : List[Boolean] = pList.length ==  qList.length match{
  case true => pList
  case false => { if(qList.length>pList.length) pList else qList}
}
def big(pList:List[Boolean],qList:List[Boolean]) : List[Boolean] = pList.length == qList.length match{
  case true => pList
  case false => { if(qList.length>pList.length) qList else pList}
}
// This function converts a binary integer list into its corresponding boolean list.
def convertIntListToBooleanList(intList: List[Int]) = {
  intList.map(element => if(element == 0) false else true).reverse
}

def convertBooleanListToIntList(boolList:List[Boolean]):List[Int] ={
  boolList.map(element => if(element == true) 1 else 0).reverse
}
// This function determines what the next carry bit should be based on current bits.
def getNextCarryBit(pBit: Boolean, qBit: Boolean, carryBit: Boolean): Boolean = {
  ((pBit ^ qBit) && carryBit || (pBit && qBit))
}
def binaryAddition(pList: List[Int], qList: List[Int]) = {
  convertBooleanListToIntList(doBinaryAddition(convertIntListToBooleanList(pList), convertIntListToBooleanList(qList), false))
}
val pTest1: List[Int] = List (1, 1, 1, 1, 0)
val qTest1: List[Int] = List(1, 0, 1, 1)
val test1ExpectedSolution: List[Int] = List(1, 0, 1, 0, 0, 1)

val pTest2: List[Int] = List (1, 0, 0, 1, 1, 0, 1)
val qTest2: List[Int] = List(1, 0, 0, 1, 0)
val test2ExpectedSolution: List[Int] = List(1, 0, 1, 1, 1, 1, 1)

val pTest3: List[Int] = List (1, 0, 0, 1, 0, 0, 1)
val qTest3: List[Int] = List(1, 1, 0, 0, 1)
val test3ExpectedSolution: List[Int] = List(1, 1, 0, 0, 0, 1, 0)

val pTest4: List[Int] = List (1, 0, 0, 0, 1, 1, 1)
val qTest4: List[Int] = List(1, 0, 1, 1, 0)
val test4ExpectedSolution: List[Int] = List(1, 0, 1, 1, 1, 0, 1)

// Testing binary addition.
if (binaryAddition(pTest1, qTest1).equals(test1ExpectedSolution)) println("Test 1 passes!") else println("Test 1 fails.")
if (binaryAddition(pTest2, qTest2).equals(test2ExpectedSolution)) println("Test 2 passes!") else println("Test 2 fails.")
if (binaryAddition(pTest3, qTest3).equals(test3ExpectedSolution)) println("Test 3 passes!") else println("Test 3 fails.")
if (binaryAddition(pTest4, qTest4).equals(test4ExpectedSolution)) println("Test 4 passes!") else println("Test 4 fails.")
// Extra Credit workspace*/

def binarySubtraction(pList:List[Int], qList:List[Int]):List[Int]={
  binaryAddition(pList, twoComplement(qList))
}
def twoComplement (firstList:List[Int]):List[Int] ={
  val newList : List[Int] = List(1)
  binaryAddition(convertBooleanListToIntList(convertIntListToBooleanList(firstList).map(element => !element)), newList)
}
binarySubtraction(List(0,0,0,0,0,0,0,0), List(0,1,0,0,1,0,1,1))
//Output should be 10110101