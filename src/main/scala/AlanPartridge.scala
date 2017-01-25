object AlanPartridge {
  val alanisms = List("Pear Tree", "Chat","Dan","Toblerone","Lynn","Alpha Papa","Nomad")
  val minesAPint = "Mines a pint"
  val spike = "I've stood on a spike!"

  def findWords(words: List[String]) = {


    // Implentation 1 - Recursive Pattern Matching

    //          def helper(acc: String="", words: List[String]): String = {
    //            words match {
    //              case Nil => acc
    //              case h :: t if alanisms.contains(h) => helper(acc + '!', t)
    //              case h :: t => helper(acc, t)
    //            }
    //          }
    //          val exclamations = helper("", words)
    //          if (exclamations.length==0) spike else
    //          minesAPint+exclamations

    //Implementation 2 - Map Filter

    //          val exclamations= words.map(word=>if(alanisms.contains(word)) "!" else "").filter(_=="!").mkString
    //          if (exclamations.length==0) spike else
    //            minesAPint+exclamations

    //implementation3 - Partial Function

        val exclamations = words.collect { case word: String if alanisms.contains(word) => "!" }.mkString
        if (exclamations=="") spike
        else
          minesAPint + exclamations

    //implementation 4 - FoldLeft
    //
    //    def buildResponse(returnMessage:String,word:String)={
    //      if (alanisms.contains(word)) {
    //        if (returnMessage == spike)  minesAPint + "!"
    //        else returnMessage + "!"
    //      } else {
    //        returnMessage
    //      }
    //    }
    //    words.foldLeft(spike){buildResponse(_,_)}

    //  implentation 5 Partial Function with bespoke Contains function

    //    def contains(word:String)={
    //      def search(l:List[String]=alanisms):Boolean={
    //        l match {
    //          case Nil=>false
    //          case h::t if(h==word) => true
    //          case h::t => search(t)
    //        }
    //      }
    //      search()
    //    }
    //
    //    val exclamations=words.collect { case word: String if contains(word) => "!" }.mkString
    //    if (exclamations.length == 0) spike
    //    else
    //      minesAPint + exclamations

    //implementation 6 For comprehensions

    //   val exclamations= (for (
    //      allanism<-alanisms;
    //      word<-words
    //      if(word==allanism)
    //    ) yield ("!")).mkString
    //
    //    if (exclamations=="") spike
    //    else
    //      minesAPint + exclamations
    //  }

    //implementation 7 err something to do with keysets

//    alanisms.size == words.size && alanisms.toSet == words.toSet
//    val wordsKeySet = words.groupBy(identity)
//    val alanismsKeySet = alanisms.groupBy(identity)
//    val exclamations=List.fill((words diff (wordsKeySet.keySet -- alanismsKeySet.keySet).toList).length)("!").mkString
//    if (exclamations=="") spike
//       else
//          minesAPint + exclamations
  }
  def findWordsDistinct(words:List[String]):String= {

        val exclamations = (for(_<-words.intersect(alanisms)) yield "!").mkString
        if (exclamations.length == 0) spike
        else
          minesAPint + exclamations

//    val alanismsSet = alanisms.toSet
//    val wordsSet = words.toSet
//    val exclamations= List.fill((alanismsSet.size + wordsSet.size) - (alanismsSet ++ wordsSet).size)("!").mkString
//    if (exclamations.length == 0) spike
//    else
//      minesAPint + exclamations
  }

}
