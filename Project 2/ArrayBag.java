/**
 * Name     Yael Hernandez
 * Course:  CSC270 Data Structures
 * Lab:     Number 2
 * File:    ArrayBag.java
 * 
 */

/**
 * @author gaok
 *
 */
public final class ArrayBag<T> implements BagInterface<T>{

	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	
	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag()
	{
		this (DEFAULT_CAPACITY);
	} // end default constructor
	
	/** Creates an empty bag having a given capacity.
    @param desiredCapacity  The integer capacity desired. */
	@SuppressWarnings("unchecked")
	public ArrayBag(int desiredCapacity)
	{
		bag=(T[]) new Object[desiredCapacity];
		numberOfEntries=0;
	} // end constructor

	
	
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
		if(numberOfEntries < bag.length) {
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		return false;
	}

	@Override
	public T remove() {
		if(isEmpty ()) {
			return null;
		}
		numberOfEntries--;
		return bag[numberOfEntries];
	}

	@Override
	public boolean remove(T anEntry) {
		int test;
		test = numberOfEntries;
		for(int i = 0; i < numberOfEntries; i++) {
			if(anEntry == bag [i]) {
				bag [i] = bag[numberOfEntries - 1];
				numberOfEntries--;
				i--;
			}	
		}
		if (test == numberOfEntries) {
			return false;
		}
		else 
			return true;
	}

	@Override
	public void clear() {
		
		numberOfEntries = 0;
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		for(int i = 0; i < numberOfEntries; i++) {
			if(anEntry.equals(bag[i])) {
				counter++;
			}
		}
		return counter;
	}

	@Override
	public boolean contains(T anEntry) {
		
		 boolean found = false;
	        for (int i = 0; !found && (i< numberOfEntries); i++)
	        {
	            if (anEntry.equals(bag[i]))
	                found =true;
	        }
	        return found;
	}

	@Override
	public T[] toArray() {
		T[] temp = (T[]) new Object[numberOfEntries];
		for(int i = 0; i < numberOfEntries; i++) {
			temp [i] = bag [i];
		}
		return temp;
	}

}