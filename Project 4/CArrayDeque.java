public class CArrayDeque<T> {
	
	private T[] items;
	private int front;
	private int back;
	private int size;
	final static int CAPACITY=10;
	
	// Default constructor
	public  CArrayDeque() {
		
		items = (T[]) new Object[CAPACITY];
		size = 0;
		front = 0;
		back = CAPACITY -1;
		
	}
	
	/** Sees whether this queue is empty.
	 @return  True if the queue is empty, or false if not. */
	public boolean isEmpty() {
		if(front == -1) {
			return true;
		}
		return false;
	}

	/** Adds a new entry to this queue at front.
    @param newEntry  The object to be added as a new entry.
    @return  True if the addition is successful, or false if not. */
	public boolean addFront(T newEntry) {
		
		if(size < CAPACITY) { 
			if(front > 0) 
			{
				front--;
			}
		else
			front = CAPACITY - 1;
			
			items[front] = newEntry;
			size++;
			return true;
	}	
		
		return false;
	}
	
	/** Adds a new entry to this queue at back.
    @param newEntry  The object to be added as a new entry.
    @return  True if the addition is successful, or false if not. */	
	public boolean addBack(T newEntry) {
		if(size > CAPACITY) {
			return false;
		}
		if(back == items.length - 1) {
			back = 0;
		}
		else {
			back++;	
		}
		
		items[back] = newEntry;
		return false;
	}
	
	/** Removes the entry at front from the queue, if possible.
    @return True if the removal was successful, or false if not. */
	public boolean removeFront() {

		if(items[front] == null && items[back] == null){
			return false;
		}
		else
		{
			items[front] = null;
		}	
			if (front < CAPACITY - 1) {
				front++;
			}
			else 
			{ 
				front = 0;
				back--;
			}
			size++;
			return true;
	
		}
	
	/** Removes the entry at back from the queue, if possible.
    @return True if the removal was successful, or false if not. */
	public boolean removeBack() {
		
		if(isEmpty())
		{
			return false;
		}
		 
        if (front == back) {
            front = -1;
            back = -1;
        }
        else if (back == 0){
            back = size-1;
            
        }
        else{
        	items[back] = null;
            back --;
            
        }
        return true;
    }
		
	
	/** Retrieve the entry at front in the queue, if possible.
    @return the front entry if the retrieve was successful, or null if not. */
	public T retrieveFront() {

        if (isEmpty())
            return null;
        
        else
            return items[front];	
	}

	/** Retrieve the entry at back in the queue, if possible.
    @return the front entry if the retrieve was successful, or null if not. */
	public T retrieveBack() {
		
	    if (isEmpty()) {
            return null;
	    }
        else {
            return items[back];		
        }
	}
	
	/** Retrieves all entries that are in this queue.
    @return  A newly allocated array of all the entries in this queue. */
	public T[] toArray(){
		
		T[] temp = (T[]) new Object[CAPACITY];
		for(int i = 0; i < items.length; i++) {
			temp [i] = items [i];
		}
		return temp;		
	}
	
}
