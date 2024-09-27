package liststuff;

public class LinkedList {
  private Link first;
  private Link last;

  public boolean isEmpty(){
    return ((this.first == null) && (this.last == null));
  }

  public int size(){
    if(this.isEmpty()){
      return 0;
    }
    Link aLink = this.first;
    int count = 0;
    while(aLink != null){
      ++count;
      aLink = aLink.getAfter();
    }
    return count;
  }

  public String get(int index){
    if (index < 0 || index > (this.size()-1) || this.isEmpty()){
      return null;
    }
    Link aLink = this.first;
    int count = 0;
    while(count < index && aLink != null){
      aLink = aLink.getAfter();
      ++count;
    }
    return aLink.getItem();
  }

  public void addFirst(String anItem){
    Link oldFirstLink = this.first;
    Link aLink = new Link(anItem);
    this.first = aLink;
    if (this.last != null){
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
    if(this.first != null){
      aLink.setBefore(oldLastLink);
      oldLastLink.setAfter(aLink);
    } else {
      this.first = aLink;
    }
    return;
  }

  public String removeFirst(){
    if (this.isEmpty()){
      return null;
    }
    Link oldFirstLink = this.first;
    this.first = oldFirstLink.getAfter();
    if(this.first == null){
      this.last = null;
    } else {
      this.first.setBefore(null);
      oldFirstLink.setAfter(null);
    }
    return oldFirstLink.getItem();
  }

  public String removeLast(){
    if(this.isEmpty()){
      return null;
    }
    Link oldLastLink = this.last;
    this.last = oldLastLink.getBefore();
    if(this.last == null){
      this.first = null;
    } else {
      this.last.setAfter(null);
      oldLastLink.setBefore(null);
    }
    return oldLastLink.getItem();
  }
}
