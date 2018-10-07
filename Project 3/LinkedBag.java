/**
   A class of bags whose entries are stored in a chain of linked nodes.
	The bag is never full.
*/

public class LinkedBag<T> implements BagInterface<T>{



	private class Node 
	{
		private T    data; // Entry in bag
		private Node next; // Link to next node
	
		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
	} // end Node

	
	private Node firstNode;       // Reference to first node
	private int numberOfEntries;

	// Default constructor
	public LinkedBag() 
	{
		
		
	} // end default constructor
	
	@Override
	public int getCurrentSize() {
		
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
	
		return numberOfEntries <= 0;
	}

	@Override
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}

	@Override
	public T remove() {
		if(firstNode == null) return null;
		T buffer = firstNode.data;
		numberOfEntries--;
		firstNode = firstNode.next;
		return buffer;
	}

 	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node getReferenceTo(T anEntry)
	{
		Node currentNode; 
		
		for (currentNode = firstNode;currentNode != null; currentNode = currentNode.next)
		{
			if (anEntry==currentNode.data)
				return currentNode;
		} // end while
		return currentNode;
	} // end getReferenceTo

	@Override
	public boolean remove(T anEntry) {

		boolean flag = false;
		Node targetNode = getReferenceTo(anEntry);
		while(targetNode != null) {
			targetNode.data = firstNode.data;
			firstNode = firstNode.next;
			flag = true;
			targetNode = getReferenceTo(anEntry);
			numberOfEntries--;
		}
		return flag;
	}

	@Override
	public void clear() {
		
		numberOfEntries = 0;
		firstNode = null;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int loopCounter = 0;
		Node currentNode = firstNode;
		while((loopCounter < numberOfEntries) && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				frequency++;
			loopCounter++;
			currentNode = currentNode.next;
		}
		return frequency;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode; 
		while (!found && (currentNode != null)) {
			if(anEntry.equals(currentNode.data))
				found = true;
			else 
				
			currentNode = currentNode.next;
		}
		return found; 
	}

	@Override
	public T[] toArray() {
		T[] temp = (T[]) new Object[numberOfEntries];
		int index = 0;
		for(Node tmp = firstNode; tmp != null; tmp = tmp.next) {
			temp [index] = tmp.data;
			index++;
		}
		return temp;
	}
	
}
