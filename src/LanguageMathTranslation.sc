val chinese:List[String] = List("ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu" ,"shi")
val english:List[String] = List("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")

def go(aList:List[String])={
  var numList:List[Int] = convertList(aList)
  var finalList:List[Int] = numList filter(_ > -1)
  print("Translate: ")
  translate(finalList)
  println();
  print("Addition: ")
  addNumDisplay(finalList)
  print(" = ")
  print(addNum(finalList))
  println();
  print("Multiplication: ")
  mulNumDisplay(finalList)
  print(" = ")
  print(mulNum(finalList))
  println();
}
def convertList(aList:List[String]): List[Int] ={
  aList.map(element => convertChinese(element))
}
def convertChinese (text:String): Int = text.toLowerCase match{
  case "ling" => 0
  case "yi" => 1
  case "er" => 2
  case "san" => 3
  case "si" => 4
  case "wu" => 5
  case "liu" => 6
  case "qi" => 7
  case "ba" => 8
  case "jiu" => 9
  case "shi" => 10
  case "zero" => 0
  case "one" => 1
  case "two" => 2
  case "three" => 3
  case "four" => 4
  case "five" => 5
  case "six" => 6
  case "seven" => 7
  case "eight" => 8
  case "nine" => 9
  case "ten" => 10
  case _ => -1
}
def translate(numList:List[Int]):Unit= {
  if(!numList.isEmpty){
    print(numList.head+" ")
    translate(numList.tail)
  }
}
def addNum(numList:List[Int]): Int = numList match{
  case Nil => 0
  case x::tail => x+addNum(tail)
}

def addNumDisplay(numList:List[Int]):Unit = {
  if(!numList.isEmpty){
    if(numList.length != 1) {
      print(numList.head + " + ")
      addNumDisplay(numList.tail)
    }else{
      print(numList.head)
      addNumDisplay(numList.tail)
    }
  }
}

def mulNum(numList:List[Int]): Int = numList match{
  case Nil => 1
  case x::tail => x*mulNum(tail)
}
def mulNumDisplay(numList:List[Int]):Unit = {
  if(!numList.isEmpty){
    if(numList.length != 1) {
      print(numList.head + " * ")
      mulNumDisplay(numList.tail)
    }else{
      print(numList.head)
      mulNumDisplay(numList.tail)
    }
  }
}

go(List("yi","josh", "three", "si"))