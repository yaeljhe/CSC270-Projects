package sorting;

/**
 * This class implements six different comparison sorts (and an optional
 * heap sort for extra credit):
 * 
 * insertion sort
 * selection sort
 * shell sort
 * quick sort
 * bubble sort
 * merge sort
 * (extra credit) heap sort
 * 
 * It also has a method that runs all the sorts on the same input array and
 * prints out statistics.
 */

public class SortingComparisons{

    /**
     * Sorts the given array using the insertion sort algorithm. Note: after
     * this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <T extends SortObject> void insertionSort(T[] A) {
	    	for (int i = 1; i < A.length; i++) 
	    		{
		    		SortObject tmp = new SortObject();
		    		tmp.assignTo(A[i]); 
		    		
		    		while(i > 0 && tmp.compareTo(A[i-1]) < 0)
		    		{
		    			A[i].assignTo(A[i-1]); 
		    			i--;
		    		}
		    			A[i].assignTo(tmp); 
	    		}    	    
    }
    /**
     * Sorts the given array using the selection sort algorithm. 
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <T extends SortObject> void selectionSort(T[] A) {
		int n = A.length; 
		   	for (int i = 0; i < n-1; i++)
		   		{
		         int min = i; 
		         for (int j = i+1; j < n; j++)
		             if (A[j].compareTo(A[min]) == -1) 
		             min = j;

		            SortObject tmp = new SortObject();
		            tmp.assignTo(A[min]);
		            A[min].assignTo(A[i]);
		            A[i].assignTo(tmp);
		        }
    }  

    /**
     * Sorts the given array using the bubble sort algorithm.
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <T extends SortObject> void bubbleSort(T[] A) {
    		int n = A.length;
    		
    		for (int i=0; i<n-1; i++)
    		{
    			for(int j=0; j<n-i-1; j++)
    			{
    				if(A[j].compareTo(A[j+i])==1)
    				{   					
    					SortObject tmp=new SortObject();
    					tmp.assignTo(A[j]);
    					A[j].assignTo(A[j+1]);
    					A[j+1].assignTo(tmp);
    				}
    			}
    		}
        
    }
    
    
    /**
     * Sorts the given array using the shell sort algorithm.
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
 	public static <T extends SortObject> void shellSort(T[] A)
 	{
 		int l = A.length;
	        for (int g = l/2; g > 0; g /= 2)
	        {

	            for (int i = g; i < l; i += 1)
	            {
	            	SortObject tmp = new SortObject();
	                tmp.assignTo(A[i]);

	                int j;
	               	for( j = i; j >= g && tmp.compareTo( A[ j - g ] ) < 0; j -= g )
	                    A[j].assignTo(A[j - g]);
	 
	                A[j].assignTo(tmp);
	            }
	        } 	 	
 	} // end shellSort

 
    /**
     * Sorts the given array using the merge sort algorithm. 
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
   
 	public static <T extends SortObject> void mergeSort(T[] A) {
       
 		mergeRsort(A,0,A.length-1);
 	}
 	
 	 private static <T extends SortObject> void mergeRsort(T[] A, int l, int r) {
 		 if(	r - l < 1) return;
 		 int mid = (l + r)/2;
 		 mergeRsort(A, l, mid);
 		 mergeRsort(A, mid + 1, r);
 		 merge(A,l,mid,r);		
 	 }	
 		
 	@SuppressWarnings("unchecked")	private static <T extends SortObject> void merge(T[] A, int p, int mid, int q) 
 	{
 		SortObject[] tmp = new SortObject[q-p+1]; 
 		int i = p;
 		int j = mid+1;
 		int k = 0;
 		while (i <= mid && j <= q) {
 		    if (A[i].compareTo(A[j])<=0)
 			tmp[k] = ((A[i++]));
 		    else
 			tmp[k] = ((A[j++]));
 		    k++;
 		}
 		if (i <= mid && j > q) {
 		    while (i <= mid) 
 			tmp[k++]=((A[i++]));
 		} else {
 		    while (j <= q)
 			tmp[k++]=((A[j++]));
 		}
 		for (k = 0; k < tmp.length; k++) {
 		    A[k+p] = ((T)(tmp[k])); 
 		}	
 	}
 		
    /**
     * Sorts the given array using the quick sort algorithm, using the median of
     * the first, last, and middle values in each segment of the array as the
     * pivot value. 
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A   the array to sort
     */
    public static <T extends SortObject> void quickSort(T[] A) {
    		sorting(A, 0, A.length - 1);
    }
    public static <T extends SortObject> void sorting(T[] A, int str, int end){ 
	    	int n = sortingR(A, str, end); 
	    	if (str < n - 1)
	    		{ 
	    		sorting(A, str, n - 1); 
	    		} 
	    	if (end > n)
	    		{ 
	    		sorting(A, n, end); 
	    		} 
	}
    public static <T extends SortObject> int sortingR(T[] A, int l, int r) {
		T p = A[l]; 
		while (l <= r) { 
			 
			while (A[l].compareTo(p)<0) {
				l++; 
				} 
			
			while (A[r].compareTo(p)>0) {
				r--; 
				}  
			if (l <= r) {
				SortObject temp = new SortObject();
				temp.assignTo(A[l]);
				A[l].assignTo(A[r]); 
				A[r].assignTo(temp);
				l++; 
				r--; 
				} 
			} 
				return l; 
	}


        
    /**
     * Sorts the given array using the heap sort algorithm outlined below. 
     * Note: after this method finishes the array is in sorted order.
     * 
     * The heap sort algorithm is:
     * 
     * for each i from 1 to the end of the array
     *     insert A[i] into the heap (contained in A[0]...A[i-1])
     *     
     * for each i from the end of the array up to 1
     *     remove the max element from the heap and put it in A[i]
     * 
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <T extends SortObject> void heapSort(T[]  A)
    {
    	// TODO: implement this sorting algorithm
       	
    }    
    
       
    
 
    /**
     * Internal helper for printing rows of the output table.
     * 
     * @param sort          name of the sorting algorithm
     * @param compares      number of comparisons performed during sort
     * @param moves         number of data moves performed during sort
     * @param milliseconds  time taken to sort, in milliseconds
     */
    @SuppressWarnings("unused")
	private static void printStatistics(final String sort, final int compares, final int moves,
                                        final long milliseconds) {
        System.out.format("%-23s%,15d%,15d%,15d\n", sort, compares, moves, 
                          milliseconds);
    }

    /**
     * Sorts the given array using the six (heap sort with the extra credit)
     * different sorting algorithms and prints out statistics. The sorts 
     * performed are:
     * 
     * insertion sort
     * selection sort
     * shell sort
     * quick sort
     * bubble sort
     * merge sort
     * (extra credit) heap sort
     * 
     * The statistics displayed for each sort are: number of comparisons, 
     * number of data moves, and time (in milliseconds).
     * 
     * Note: each sort is given the same array (i.e., in the original order). 
     * 
     * @param A  the array to sort
     */
    public static <T extends SortObject>void runAllSorts(T[] A) {
        System.out.format("%-23s%15s%15s%15s\n", "algorithm", "data compares", 
                          "data moves", "milliseconds");
        System.out.format("%-23s%15s%15s%15s\n", "---------", "-------------", 
                          "----------", "------------");
        // TODO: run each sort and print statistics about what it did
        
        long startTime, endTime;
        T[] arr=reset(A);
        startTime = System.nanoTime();
        insertionSort(arr);
        endTime = System.nanoTime();

        System.out.format("%-23s%15s%15s%15s\n", "insertion sort", SortObject.getCompares(), 
                SortObject.getAssignments(),(endTime-startTime)/1000000);
        
        arr=reset(A);
        startTime = System.nanoTime();
        selectionSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "selection sort", SortObject.getCompares(), 
                 SortObject.getAssignments(),(endTime-startTime)/1000000);
  
        
        arr=reset(A);
        startTime = System.nanoTime();
        shellSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "shell sort", SortObject.getCompares(), 
                   SortObject.getAssignments(),(endTime-startTime)/1000000 );
          

        arr=reset(A);
        startTime = System.nanoTime();
        quickSort(arr);
        endTime = System.nanoTime();
          System.out.format("%-23s%15s%15s%15s\n", "quick sort", SortObject.getCompares(), 
                    SortObject.getAssignments(),(endTime-startTime)/1000000);
    

        arr=reset(A);
        startTime = System.nanoTime();
        heapSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "heap sort", SortObject.getCompares(), 
                    SortObject.getAssignments(),(endTime-startTime)/1000000);

          
        arr=reset(A);
        startTime = System.nanoTime();
        bubbleSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "bubble sort", SortObject.getCompares(), 
                    SortObject.getAssignments(),(endTime-startTime)/1000000);

           
        arr=reset(A);
        startTime = System.nanoTime();
        mergeSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "merge sort", SortObject.getCompares(), 
                    SortObject.getAssignments(),(endTime-startTime)/1000000);
    }
    
    @SuppressWarnings("unchecked")
	private static <T extends SortObject> T[] reset(T[] A){

    	SortObject[] arr = TestSort.makeCopy(A, A.length); 
        SortObject.resetCompares();
    	SortObject.resetAssignments();
    	return (T[])arr;
        
    }
}
