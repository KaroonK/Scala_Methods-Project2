import scala.collection.immutable.Nil

// COSC 455 - Programming Languages: Implementation and Design
// Project 2

// NAME: Karoon Khatiwada
//Problem 1 - Prime Numbers

def prime (Num : Int) : Boolean = {
  var num1 = 3
  primeHelper(Num, num1) match {
    case true => true
    case false => false
  }
}
def primeHelper(x:Int, y:Int) : Boolean ={
  var num2 = y
  x match{
    case 0 => false
    case 1 => true
    case 2 => true
    case _ => {
      x % y match {
        case 0 =>  {
          if (x == num2)  true
          else  false
        }
        case _ => num2+= 1; primeHelper(x,num2)
      }
    }

  }

}
prime(121) //First test case for prime
prime(577) //Second test case for prime

//Problem 2 - Twin Primes
def twinprimes (num1:Int, num2: Int):Boolean = {
  num1 - num2 match{
    case 2 => {
      if(prime(num1) && prime(num2)){
        true
      }else
        false
    }
    case -2 =>{
      if(prime(num1) && prime(num2)){
        true
      }else
        false
    }
    case _ => false
  }
}
twinprimes(41,43) //First test case for twinprimes
twinprimes(43,47) //Second test case for twinprimes

def twinprimeslist(n:Int): List[Int] = {
  duplicate(twinprimeslisthelper(n).reverse)
}
def twinprimeslisthelper(n:Int) :List[Int] = n match{
  case 3 => Nil
  case _ =>{
    if(prime(n) && prime(n-2)){
      n::n-2::twinprimeslisthelper(n-2)
    }else
      twinprimeslisthelper(n-1)
  }
}
def duplicate(n:List[Int]):List[Int] = n match{
  case Nil => Nil
  case x::List() => List(x)
  case x::tail if(x==tail.head) => duplicate(tail)
  case x::tail => x::duplicate(tail)

}
twinprimeslist(50) //First test case for twinprimeslist
// Test Cases
/*val pTest1: List[Int] = List (1, 1, 1, 1, 0)
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

// This function does the binary addition when there are uneven lists and still must
// finish the add with the carry bits.
def finishBinaryAdd(remainingBits: List[Boolean], carryBit: Boolean): List[Boolean] = ???

// This function determines what the next carry bit should be based on current bits.
def getNextCarryBit(pBit: Boolean, qBit: Boolean, carryBit: Boolean): Boolean = ???

// This function does the binary addition of two Booleans and a carry bit.
def addBits(pBit: Boolean, qBit: Boolean, carryBit: Boolean): Boolean = ???

// This function does the binary addition of two boolean lists. Note that the lists may not be equal in length.
def doBinaryAddition(pBits: List[Boolean], qBits: List[Boolean], carryBit: Boolean): List[Boolean] = ???

// This function converts a binary integer list into its corresponding boolean list.
def convertIntListToBooleanList(intList: List[Int]) = ???

// This function converts a boolean list into its corresponding binary integer list.
def convertBooleanListToIntList(booleanList: List[Boolean]) = ???

/* This is the "main" function to do binary addition. This function should:
    1. Convert the input parameter lists from integers to boolean. Use Scala reverse
    2. Reverse the lists (since binary addition is performed right to left). Use Scala reverse.
    3. Perform the binary addition with the doBinaryAddition function.
    4. Reverse the lists (to get back in proper order). Use Scala reverse.
    5. Convert the answer back to binary integer form for output.
  Note that the initial carry bit is assumed to be 0 (i.e., false).
*/
def binaryAddition(pList: List[Int], qList: List[Int]) = ???

// Testing binary addition.
if (binaryAddition(pTest1, qTest1).equals(test1ExectedSolution)) println("Test 1 passes!") else println("Test 1 fails.")
if (binaryAddition(pTest2, qTest2).equals(test2ExectedSolution)) println("Test 2 passes!") else println("Test 2 fails.")
if (binaryAddition(pTest3, qTest3).equals(test3ExectedSolution)) println("Test 3 passes!") else println("Test 3 fails.")
if (binaryAddition(pTest4, qTest4).equals(test4ExectedSolution)) println("Test 4 passes!") else println("Test 4 fails.")
// Extra Credit workspace*/
