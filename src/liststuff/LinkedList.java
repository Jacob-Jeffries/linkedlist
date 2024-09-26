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
      while(aLink != null){
        ++count;
        aLink = aLink.getAfter();
      }
      return count;
    }
  }

  public String get(int index){

    if (this.isEmpty()){
      return null;
    } else if (index < 0 || index > (this.size()-1)){
      return null;
    } else if (this.first == this.last){
      return this.first.getItem();
    } else {
      Link aLink = this.first;
      int count = 0;
      while(count < index && aLink != null){
        aLink = aLink.getAfter();
        ++count;
      }
      return aLink.getItem();
    }
  }

  public void addFirst(String anItem){
    Link aLink = new Link(anItem);


    if (!this.isEmpty()){
      this.first = aLink;

      Link oldFirstLink = this.first;
      aLink.setAfter(oldFirstLink);
      oldFirstLink.setBefore(aLink);
    }else {
      this.first = aLink;

      this.last = aLink;
    }
    return;
  }

}
