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
      sort the user's data, implementing insertion sort
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
	
	private int champIndex(int minIndex) {
		 String champ = "ZZZZZZZZ";
		 for (int index = minIndex; index < elements.size(); index++){
			 if (elements.get(index).compareTo(champ) < 0){
				 minIndex = index;
				 champ = elements.get(index);
			 }
		 }
		 return minIndex;
     }
	

}
