

class CountR(XNumber:Int) {
  var num : Int= XNumber

  def inc()=new CountR(num+1)

  def dec()=new CountR(num-1)

  def show()= println("num= "+ num)


}