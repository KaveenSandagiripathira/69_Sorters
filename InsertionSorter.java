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
      sort the user's data, implementing insertion sort
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
