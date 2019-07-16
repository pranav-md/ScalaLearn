

class Film(flname: String,xyearofrl: Int, dir: Director)  {
    var name=flname
    var yearOfRelease=xyearofrl
    var typeDirector=dir
    
    def directorsAge()
    {
        return yearOfRelease-typeDirector.yearofBirth
    }
    
    def isDirectedBy(xname: String)
    {
          if(xname==typeDirector.firstName+" "+typeDirector.lastName)
            return true;
          else 
            return false;
    }

}