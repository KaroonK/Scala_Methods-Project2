import scala.collection.immutable.Nil

// COSC 455 - Programming Languages: Implementation and Design
// Project 2

// NAME: Karoon Khatiwada
//First Part
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

//Goldbach's Conjecture
def goldbach(n:Int) =n match{
  case (n) if(n<=2) => println("Has to be greater than 2")
  case (n) if(n%2  == 1) => println("Has to be an even number")
  case (n) if(n%2  == 0) => {
    var num = 1
    goldbachHelper(n,num)
  }
}
def goldbachHelper(n:Int, o:Int) :Unit= {
  var num1 = n
  var num2 = o
  o match{
    case 2 => goldbachHelper(num1, num2+1)
    case (o) if(o == n) =>
    case (o) if(prime(n-o)) => {
      println(o + " + " + (n-o) + " = " + n)
    }
    case _ => goldbachHelper(num1, num2+1)

  }
}
goldbach(28)