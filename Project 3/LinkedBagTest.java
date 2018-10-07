/**
 * A test of the constructors and the methods add, toArray, isEmpty, getCurrentSize, 
 * getFrequencyOf, and contains for the class ArrayBag.
    
*/
public class LinkedBagTest
{
	public static void main(String[] args) 
	{
		
		String[] contentsOfBag = {"One", "One", "Two", "One", "Three", "One"};

      // Tests on an empty bag
      BagInterface<String> aBag = new LinkedBag<>();
      System.out.println("Testing an initially empty bag:");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      testIsEmpty(aBag, true);
      String[] testStrings1 = {"", "Two"};
      testFrequency(aBag, testStrings1);
      testContains(aBag, testStrings1);
      testRemove(aBag, testStrings1);
      System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
      System.out.println();
      // Adding strings
      System.out.println("Adding " + contentsOfBag.length +
                         " strings to an initially empty bag with" +
                         " the capacity to hold more than " +
                         contentsOfBag.length + " strings:");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      testAdd(aBag, contentsOfBag);
      
      // Tests on a bag that is not empty
      testIsEmpty(aBag, false);
      String[] testStrings2 = {"One", "Two", "Three", "Four", "XXX"};
      testFrequency(aBag, testStrings2);
      testContains(aBag, testStrings2);
		
      // Removing strings
      String[] testStrings3 = {"", "Two", "One", "Three", "XXX"};
      testRemove(aBag, testStrings3);
      
      System.out.println("\nClearing the bag:");
      aBag.clear();
      testIsEmpty(aBag, true);
      displayBag(aBag);
      System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
      System.out.println();
      
      // Filling an initially empty bag to capacity
      System.out.println("\nTesting an initially empty bag that " +
                         " will be filled to capacity:");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      aBag = new LinkedBag<String>();
      String[] contentsOfBag2 = {"One", "Two", "One", "Three", "Two", "Three", "Four"};
      testAdd(aBag, contentsOfBag2);
      
      System.out.println("Try to add XXX to the full bag:");
      if (aBag.add("XXX")) {
         System.out.println("Added a string beyond the bag's capacity: OK!");
         displayBag(aBag);
      }
      else
         System.out.println("The method add cannot add another string: ERROR!");
	} // end main
	
   // Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
         System.out.print(content[index] + " ");
		} // end for
      System.out.println();
      
		displayBag(aBag);
	} // end testAdd

   // Tests the two remove methods.
	private static void testRemove(BagInterface<String> aBag, String[] tests)
	{
      for (int index = 0; index < tests.length; index++)
      {
         String aString = tests[index];
         if (aString.equals("") || (aString == null))
         {
            // test remove()
            System.out.println("\nRemoving a string from the bag:");
            String removedString = aBag.remove();
            System.out.println("remove() returns " + removedString);
         }
         else
         {
            // test remove(aString)
            System.out.println("\nRemoving \"" + aString + "\" from the bag:");
            boolean result = aBag.remove(aString);
            System.out.println("remove(\"" + aString + "\") returns " + result);
         } // end if
         
         displayBag(aBag);
      } // end for
	} // end testRemove

   // Tests the method isEmpty.
   // correctResult indicates what isEmpty should return.   
	private static void testIsEmpty(BagInterface<String> aBag, boolean correctResult)
	{
      System.out.print("Testing isEmpty with ");
      if (correctResult)
         System.out.println("an empty bag:");
      else
         System.out.println("a bag that is not empty:");
      
      System.out.print("isEmpty finds the bag ");
      if (correctResult && aBag.isEmpty())
			System.out.println("empty: OK.");
		else if (correctResult)
			System.out.println("not empty, but it is empty: ERROR.");
		else if (!correctResult && aBag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
		System.out.println();
	} // end testIsEmpty

   // Tests the method getFrequencyOf.
	private static void testFrequency(BagInterface<String> aBag, String[] tests)
	{
 		System.out.println("\nTesting the method getFrequencyOf:");
      for (int index = 0; index < tests.length; index++)
      {
         String aString = tests[index];
         if (!aString.equals("") && (aString != null))
         {
            System.out.println("In this bag, the count of " + tests[index] +
                               " is " + aBag.getFrequencyOf(tests[index]));
         } // end if
      } // end for
   } // end testFrequency
   
   // Tests the method contains.
	private static void testContains(BagInterface<String> aBag, String[] tests)
	{
 		System.out.println("\nTesting the method contains:");
      for (int index = 0; index < tests.length; index++)
      {
         String aString = tests[index];
         if (!aString.equals("") && (aString != null))
         {
            System.out.println("Does this bag contain " + tests[index] + 
                               "? " + aBag.contains(tests[index]));
         } // end if
      } // end for
   } // end testContains

   // Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
		                   " string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
} // end ArrayBagTest

