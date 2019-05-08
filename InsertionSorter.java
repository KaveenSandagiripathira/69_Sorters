/**
  Implement an insertion sort, in the Sorters structure
 */
import java.util.ArrayList;

public class InsertionSorter extends Sorter {


    /**
      Construct an instance to process the user's data
     */
    public InsertionSorter(  ArrayList< String> usersData) {
        super(usersData);
    }
    

    /**
	Pre-condition: The list must hold String data objects.
	
    run insert1 for posistions 1 through n - 1 in the list
	
	Post-condition: The list encapsulated in the Sorter class will be returned sorted
     */
    public void mySort() {
		for (int numSorted = 1; numSorted < elements.size(); numSorted++){
			insert1(numSorted);
			// for debugging
			// System.out.println(numSorted);
			// System.out.println( "    dbg: "
						// + "after inserting element " + elements.get(numSorted)
						// + " elements: " + elements
						// );
		}
	}
	/**
	Pre-condition: There must exist a sorted and unsorted portion of the list.
	
	Move the first unsorted element to its place in the sorted region,
	shifting all larger values, to make space, thereby expanding the sorted region.
	
	Post-condition: The first element of the unsorted portion will be inserted to the current right place.
	*/
	public void insert1(int numSorted){
		String valueToInsert = elements.get(numSorted);
		for (int indexToCompare = numSorted - 1;indexToCompare >= 0;indexToCompare--){
			if (valueToInsert.compareTo(elements.get(indexToCompare)) > 0){
				elements.set(indexToCompare + 1, valueToInsert); //Drop 
				break;
			}
			else{
				elements.set(indexToCompare, elements.set(indexToCompare + 1, elements.get(indexToCompare))); //Shift
			}
		}	
	}
	


}
