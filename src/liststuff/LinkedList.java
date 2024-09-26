package liststuff;

public class LinkedList {
  private Link first;
  private Link last;

  public boolean isEmpty(){
    return (this.first == null) && (this.last == null);
  }


  public int size(){

    Link aLink = this.first;
    int count = 0;

    if (this.isEmpty()){
      return 0;
    } else if (this.first == this.last){
      return 1;
    } else {
      while(aLink.getAfter() != null){
        ++count;
        aLink = aLink.getAfter();
      }
      return count;
    }
  }

  public String get(int index){

    if (this.isEmpty()){
      return null;
    }

    Link aLink = this.first;

    for(int i = 0; i <= index; ++i){
      aLink = aLink.getAfter();
    }

    return aLink.getItem();
  }

  public void addFirst(String anItem){
    Link aLink = new Link(anItem);
    this.first = aLink;

    if (this.isEmpty()){
      this.last = aLink;
    }else {

    }
  }

}
