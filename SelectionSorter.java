/**
  Implement an insertion sort, in the Sorters structure
 */
import java.util.ArrayList;

public class SelectionSorter extends Sorter {


    /**
      Construct an instance to process the user's data
     */
    public SelectionSorter(  ArrayList< String> usersData) {
        super(usersData);
    }
    

    /**
	Pre-condition: The list must hold String data objects.
	
    Run reigningDweeb for posisitions 0 through n - 2
	
	Post-condition: The list encapsulated in the Sorter class will be returned sorted
     */
    public void mySort() {
        for (int index = 0; index < elements.size(); index++){
			Integer nextLargerAt = champIndex(index);
			String temp = elements.get(index);
			elements.set(index, elements.get(nextLargerAt));
			elements.set(nextLargerAt, temp);
			// System.out.println( "current progress: " + elements );
		}
	}
	/**
	Pre-condition: There must exist a sorted and unsorted portion of the list.
	
	Find the smallest value in the unsorted region.
	Swap it with the first value in the unsorted region, thereby expanding the sorted region
	
	Post-condition: The minimum of the unsorted region will be the last element of the sorted region.
	
	private int champIndex(int minIndex) {
		 String champ = elements.get(minIndex);
		 for (int index = minIndex + 1; index < elements.size(); index++){
			 if (elements.get(index).compareTo(champ) < 0){
				 minIndex = index;
				 champ = elements.get(index);
			 }
		 }
		 return minIndex;
     }
	

}
