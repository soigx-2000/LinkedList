public class ListNode
{
	// instance properties
	
	private String value;
	private ListNode next;
	
	
	// constructor


	// pre-condition: initValue is a valid Object and initNext is valid ListNode.
	// post-condition: value equals initValue and next equals initNext.
	public ListNode (String initValue, ListNode initNext)
	{
		value = initValue;
		next = initNext;
		return;
	}
	
	
	// accessors

	// pre-condition: value is either null or a valid Object.
	// post-condition: value is returned.
	public String getValue()
	{
		return value;
	}


	// pre-condition: next is either null or a valid ListNode.
	// post-condition: next is returned.
	public ListNode getNext ()
	{
		return next;
	}
	
	
	// mutators
	
	// pre-condition: theNewValue is a valid Object.
	// post-condition: value equals theNewValue.
	public void setValue (String theNewValue)
	{
		value = theNewValue;
	}

	// pre-condition: theNewNext is a valid ListNode.
	// post-condition: next equals theNewNext.
	public void setNext(ListNode theNewNext)
	{
		next = theNewNext;
	}
}
