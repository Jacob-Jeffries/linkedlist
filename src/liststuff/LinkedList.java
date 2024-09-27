package liststuff;

public class LinkedList {
  private Link first;
  private Link last;

  public boolean isEmpty(){
    return ((this.first == null) || (this.last == null));
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

    if (index < 0 || index > (this.size()-1)){
      return null;
    } else if (this.isEmpty()){
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
    Link oldFirstLink = this.first;
    Link aLink = new Link(anItem);
    this.first = aLink;
    if (!this.isEmpty()){
      aLink.setAfter(oldFirstLink);
      oldFirstLink.setBefore(aLink);
    }else {
      this.last = aLink;
    }
    return;
  }

  public void addLast(String anItem){
    Link oldLastLink = this.last;
    Link aLink = new Link(anItem);
    this.last = aLink;
    if(!this.isEmpty()){
      aLink.setBefore(oldLastLink);
      oldLastLink.setAfter(aLink);
    } else {
      this.first = aLink;
    }
    return;
  }

  public String removeFirst(){
    Link oldFirstLink = this.first;
    if(this.isEmpty()){
      return null;
    } else if(this.size() == 1){
      this.first = null;
      this.last = null;
    } else {
      this.first = oldFirstLink.getAfter();
      this.first.setBefore(null);
      oldFirstLink.setAfter(null);
    }
    return oldFirstLink.getItem();
  }

  public String removeLast(){
    Link oldLastLink = this.last;
    if(this.isEmpty()){
      return null;
    } else if(this.size() == 1 ){
      this.first = null;
      this.last = null;
    } else {
      this.last = oldLastLink.getBefore();
      this.last.setAfter(null);
      oldLastLink.setBefore(null);
    }
    return oldLastLink.getItem();
  }
}
