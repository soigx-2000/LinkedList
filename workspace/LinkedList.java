/* Ziru Zhou // period 3 // CS programing 3
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList{
  //instance varialbes go here (think about what you need to keep track of!)
    private int length = -1;
    private ListNode head;
  //constructors go here
  public LinkedList(){
    this.head = null;
    this.length = 0;
  }
  public int getLength(){
    return this.length;
  }
  public ListNode getHead(){
    return this.head;
  } 
  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line){
    if (head == null){
      // if head is null, we simply set the head to the value line & makes it point to the next value: null;
        head = new ListNode(line, null);
        length++;
        return head;
      // return to stop the method
    }

    if (line.compareTo(head.getValue()) < 0){// attach in front: line come before head in alphabet
      head = new ListNode(line, head);
      length++;
      return head;
    }
    // recursion below

    return addAValue(head, line);
  }

  //precondition: line is not null
  //postcondition: adds line in the propper location into the list
  private ListNode addAValue(ListNode curr, String line){
     if (curr.getNext() == null){// base case 1
      // if the next value is null, we reach the end, point the current last node to the new node and point the new node to null
      curr.setNext(new ListNode(line, null));
      length++;
      return curr.getNext();
    }
    else if(curr.getNext().getValue().toLowerCase().compareTo(line.toLowerCase()) < 0){// recursive case
      // if next value is lower than line alphabetically, set curr to next and repeat the method
      return addAValue(curr.getNext(), line);
    }
    else{// base case 2
      // if next is after line alphabetically (None case sensitive), we are at the right spot to put line
      ListNode q = new ListNode (line, curr.getNext());//attach the new list node to the correct node
      curr.setNext(q);
      length++;
      return q;
    }
  }
  


  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    if (head == null){
      // if head is null, there will be nothing to delete;
        return null;
    }
    else if (head.getValue().equals(line)){
        // if head match the delete node
        length--;
        ListNode a = head;// get a copy to return before it is gone forever
        head = head.getNext();
        return a;
    }
    else{
      return deleteAValue(head, line);
    }
  }
  public ListNode deleteAValue(ListNode curr, String line){
    // recursion below
    if (curr.getNext().getValue().equals(line)){// base case 1
      // if the next value is match, we will remove it
      ListNode a = curr.getNext();// get a copy to return before it is gone forever
      curr.setNext(a.getNext());// with no reference to that node what so ever, it is forever forgoten and deleted
      curr = null;// set curr back to null once we done recursing
      length--;
      return a;
    }
    else if (curr.getNext() == null){// base case 2
      // if we reach the end and got nothing, there is nothing to delete.
      return null;
    }
    else{// recursive case
      // if next value is not found or null, set curr to next and repeat the method
      return deleteAValue(curr.getNext(), line);
    }
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    ListNode curr = null;
    System.out.println("show");
    String result = "";
    if (head == null){
      // if head is null, there will be nothing to show;
        return "";
    }
    else{
      curr = head;// now I won't get Null Pointer Exeption
    }
    while(curr.getNext() != null){
      result += curr.getValue() + " ";
      curr = curr.getNext();
    }
    ListNode a = curr ;//save current;
    curr = null;// set curr back to null once we done recursing
    return result + a.getValue();
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    this.head = null;
    this.length = 0;
  }
  public void reverse(){
		if(length == 1){
		}
    else{
      ListNode prev = head;
      ListNode curr = head.getNext();
      ListNode next = curr.getNext();
      while(curr != null){
        if(head == prev){
          prev.setNext(null);
        }
        curr.setNext(prev);
        prev = curr;
        curr = next;
        if(next != null){
          next = next.getNext();
        }
      }
      head = prev;
    }
  }
  public void nReverse(int n){
    if (length < n || n < 2){
      return;
    }
    else if(length < 2*n){
      ListNode prev = null;
      ListNode curr = head;
      ListNode next = curr.getNext();
      ListNode tail = null;
      for (int j = 0 ; j < n; j++){
        if(j == 0){
          tail = curr;
        } 
        curr.setNext(prev);
        prev = curr;
        curr = next;
        if (next != null){
          next = next.getNext();
        }
      }
      tail.setNext(curr);
      head = prev;
    }
    else{
      // initialize all of the tracking nodes
      ListNode prev = null;
      ListNode curr = head;
      ListNode next = curr.getNext();
      ListNode lastChunkTail = null;
      ListNode thisChunkTail = null;
      for(int i = 0;  i < length/n; i++){
        thisChunkTail = curr;
        for(int j = 0; j < n ; j++){
          curr.setNext(prev);
          prev = curr;
          curr = next;
          if(next != null){
            next = next.getNext();
          }
        }
        if(lastChunkTail == null){
          head = prev;
        }
        else{
          lastChunkTail.setNext(prev);
        }
        thisChunkTail.setNext(curr);
        lastChunkTail = thisChunkTail;
      }
    }
  }
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.addAValue("elephant");
    list.addAValue("dog");
    list.addAValue("cat");
    list.addAValue("bee");
    System.out.println(list.addAValue("ant").getValue());
    list.addAValue("zebra");
    System.out.println(list.showValues());
    list.deleteAValue("cat");
    System.out.println(list.showValues());
  }
}
